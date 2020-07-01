
import java.util.*;

/**
 * Trees without explicit links.
 * Notice that various fields/methods have the protected modifier
 * when normally they would/should be private.
 * The reason is that this supports whitebox testing.
 *
 * @author Stefan Kahrs
 * @version 1
 */
//note the constraint on A is a slight generalisation of A extends Comparable<A>
//and is generally recommended when one wants a comparison operation
//it basically allows that the comparison op is implemented at a supertype
//of A, instead of A itself;
//for the assessment itself it makes no discernable difference
class LinklessTree<A extends Comparable<? super A>>
{
    //sizes of subtrees at that node index
    protected int[] sizes;
    protected Object[] elems;

    //for annoying technical reason this has to be an array of objects
    /**
     * Constructor for objects of class LinklessTree
     */
    private static final int STARTSIZE=15;
    private LinklessTree<A> root;
    public LinklessTree()
    {
        assert STARTSIZE>0;
        elems = freshElemArray(STARTSIZE);
        sizes = new int[STARTSIZE];
    }

    //size of whole tree is the size of the subtree rooted at 0
    public int size() {
        return getSize(0);
    }

    public A getValue(int index) {
        return (A)elems[index];
    }

    //auxiliary methods to index the arrays out of bounds too
    //they may help to reduce case distinctions
    protected A getKey(int subtree) {
        if (subtree>=elems.length) return null; // out of bounds
        return getValue(subtree);
    }

    protected int getSize(int subtree) {
        if (subtree>=elems.length) return 0; // out of bounds
        return sizes[subtree];
    }

    //encapsulates the cast on the allocation
    protected Object[] freshElemArray(int capacity) {
        return new Object[capacity];
    }

    //remainder needs to be modified
    /**
     * find index position of val in tree, if there, or where it goes, if not there   
     */
                                                                          
    protected int findIndex(A val) {
        int index = 0;    
        while (index<elems.length){ //iterates through the whole tree
            if (elems[index] == null) 
            {
                return index; 
            }
            if ((val.compareTo((A)elems[index])) == 0 ) {
                return index; //it found the value
            }
            else if((val.compareTo((A)elems[index])) < 0) {
                index = 2*index+1; //the value is less than this nodes value
            }
            else {
                index = 2*index+2; //the value is more than this nodes value
            }

        }
        return index;
    }
    
   /**
     * Checks if the value is in the tree  
     * @param value The value to be searched
     * @return Whether the value was foud or not 
     */
    public boolean contains(A value) {
        int index=0;
        boolean found=false;
        while (index<elems.length && found==false){ //iterates through the tree until found or out of index
            if (elems[index] == null)
            {
                return found;  
            }
            if ((value.compareTo((A)elems[index])) == 0 ) {
                found = true; //it found the value
            }
            else if((value.compareTo((A)elems[index])) < 0) {
                index = 2*index+1; //the value is less than this nodes value
            }
            else {
                index = 2*index+2; //the value is more than this nodes value
            } 
        }
        return found;
    }

    /**  
     * Grows the space in which we can place the tree
     */
    
    protected void grow() {
        //new array with size double of the elems one
        Object[] bigelems = new Object[elems.length*2];  
        //copies the array elements
        System.arraycopy(elems, 0, bigelems, 0, elems.length);
        elems = bigelems;
        
        //new array with size double of the elems one
        int[] bigsizes = new int[sizes.length*2];  
        //copies the array elements
        System.arraycopy(sizes, 0, bigsizes, 0, sizes.length);
        sizes = bigsizes;
    }
    
    /**  
     * Returns all the non-null things from elems as an arraylist
     * @param index The index of the node
     * @return The ArrayList containing all the values that are in the node 
     */
    
    protected ArrayList<A> getArrayWithNoNulls(int index){
        ArrayList<A> returnArray = new ArrayList<>();
        // Add the root (check it's not null also)
        if (getValue(index) != null)
        { returnArray.add(getValue(index));}
        // Left node
        if (2*index+1 < elems.length && elems[2*index+1] != null) 
        { returnArray.addAll(getArrayWithNoNulls(2*index+1));}
        // Right node
        if (2*index+2 < elems.length && elems[2*index+2] != null)
        { returnArray.addAll(getArrayWithNoNulls(2*index+2));}
        return returnArray;
    }
    
    /**  
     * Fetches the i-th element, in comparsion order
     * @param i The index of the element that we want
     * @return The i-th elemnt of the sorted ArrayList
     */
    public A get(int i){ 
        // Get the non-null nodes
        ArrayList<A> nullArray = getArrayWithNoNulls(0);
        // Sort them
        Collections.sort(nullArray);
        // Checks if its out of bounds
        if (i > nullArray.size()-1){ return null;}
        return nullArray.get(i);
    }
    
 /**  
     * adds x to tree, return true if tree was modified
     * multiple copies of the equal objects in tree are not allowed
     * equality is decided by using compareTo
     * @param x The node that we want to add
     * @return Whether the tree was modified
     */
   
    public boolean insert(A x){  
        if (contains(x) == false) //checks if it already there
        {
            int index = 0;
            while (index<elems.length){ //iterate through the tree to find the place to add it
                if (elems[index] == null)
                {
                    elems[index] = x;  
                    IncrementSizes(index);
                    return true; 
                }

                else if((x.compareTo((A)elems[index])) < 0) { 
                    index = 2*index+1; //goes left if the value is less than the current node
                }
                else {
                    index = 2*index+2; //goes right if the value is bigger than the current node
                }      
            }
            if (index>=elems.length) //if there is no space then make space
            {
                grow(); //makes space
                insert(x); //inserts the value 
                return true;
            }
        }
        return false; 
    }
    
     /**  
     * Fixes the sizes array after an insert of a node
     * @param index The index of the node that was added
     */
   
     protected void IncrementSizes(int index) {
        sizes[0] = sizes[0]+1;
        A val = (A)elems[index];
        index = 0; 
        //iterates through the tree 
        //tries to find the value and on the way to find it we increase the sizes indexes of these values
        while (index<elems.length){ 
            if ((val.compareTo((A)elems[index])) == 0 ) {
                index = elems.length; 
            }
            else if((val.compareTo((A)elems[index])) < 0) {
                index = 2*index+1;
                sizes[index] = sizes[index]+1;
            }
            else {
                index = 2*index+2;
                sizes[index] = sizes[index]+1;
            }

        }
    }
    
     /**  
     * Fixes the sizes array after deletion of a node
     * @param index The index of the node that was added
     */
   
    protected void DecrementSizes(int index)
    {
        sizes[0] = sizes[0]-1;
        A val = (A)elems[index];
        index = 0; 
        //iterates through the tree 
        //tries to find the value and on the way to find it we decreases the sizes indexes of these values
        while (index<elems.length){
            if ((val.compareTo((A)elems[index])) == 0 ) {
                index = elems.length; 
            }
            else if((val.compareTo((A)elems[index])) < 0) {
                index = 2*index+1;
                sizes[index] = sizes[index]-1;
            }
            else {
                index = 2*index+2;
                sizes[index] = sizes[index]-1;
            }
        }
        
    }
    
     /**  
     * remove x from tree, return true if tree was modified
     * @param x The node that we want to delete
     * @return Whether the tree was modified
     */
    
    public boolean delete(A x){ 
        int index = findIndex(x);
        int left = 2*index+1;
        int right = 2*index+2;
        //checks if the value is in the tree
        if (contains(x) == true) {
            //checks if there are no children in this index and deletes it
            if (sizes[index]==1){ 
                DecrementSizes(index);
                elems[index]=null;
                return true;
            }
            //if there are children and there are more in the left side 
            else if(sizes[index]>1 && sizes[left]>=sizes[right])
            {
                deleteLargest(index); 
                return true; 
            }
            //if there are children and there are more in the right side
            else if(sizes[index]>1 && sizes[left]<sizes[right]){
                deleteSmallest(index); 
                return true;
            }
        }
        return false; 
    }
    
     /**  
     * find the largest in the branch and replaces it with the deleted node
     * @param subtree The node that we want to delete
     */
    private void deleteLargest(int subtree) {
        int left = 2*subtree+1; //left of substree index 
        if(left<elems.length){ //in the bounds
        if(sizes[left]==1) {//if the left doesnt have any children then delete it
            DecrementSizes(left);
            elems[subtree] = elems[left]; 
            elems[left] = null; 
        }
        else if (sizes[left] >1){ //if the left has children then get the biggest and replace it with this node
            ArrayList<A> leftnodes = getArrayWithNoNulls(left);
            Collections.sort(leftnodes);
            A largest = leftnodes.get(leftnodes.size()-1);
            int largestindex = findIndex(largest); //largest chiildren
            
            DecrementSizes(largestindex); //fixes the sizes after deletion
            elems[subtree] = elems[largestindex];
            deleteLargest(largestindex); //loops again to move the rest of the children if the exist 
        }
        else if(sizes[left]==0){
            elems[subtree] = null; //if the left doesnt exist then just remove the node
        }
    }
    else { 
       DecrementSizes(subtree);//if its out of bounds then just decrease the sizes
    }
    }
    
    /**  
     * find the smallest in the branch and replaces it with the deleted node
     * @param subtree The node that we want to delete
     */
    private void deleteSmallest(int subtree) {
        int right = 2*subtree+2; //right of substree index 
        if(right<elems.length){
        if(sizes[right]==1) {//if the left doesnt have any children then delete it
            DecrementSizes(right);
            elems[subtree] = elems[right]; 
            elems[right] = null; 
        }
        
        else if (sizes[right] >1){ //if the left has children then get the biggest and replace it with this node
            ArrayList<A> rightnodes = getArrayWithNoNulls(right);
            Collections.sort(rightnodes);
            A smallest = rightnodes.get(0);
            int smallestindex = findIndex(smallest); //smallest chiildren
            
            DecrementSizes(smallestindex);//fixes the sizes after deletion
            elems[subtree] = elems[smallestindex];
            deleteSmallest(smallestindex); //loops again to move the rest of the children if the exist 
        }
        else if(sizes[right]==0){
            elems[subtree] = null; //if the left doesnt exist then just remove the node
        }
        
    }
     else { 
       DecrementSizes(subtree); //if its out of bounds then just decrease the sizes
    }
    }
        
}