import java.util.ArrayList;

import javax.management.RuntimeErrorException;
/**ADT  integer storage : not duplicate and sort.
 */
public class IntegerSet {
    ArrayList<Integer> Numbers;

    //--------------------------------------------------------
    // Abstraction Function (AF):
    //  - AF(x) = the set of integer in the integer x.
    //--------------------------------------------------------  
      
    //--------------------------------------------------------
    // Rep Invariant (RI):
    //  - x must not contain duplicate integer.
    //  - integer in x must be sorted in ascending order.
    //  - x must not contain NULL.
    //--------------------------------------------------------  
    
    /*
     *  Constructor start create free set.
     */
    
    public IntegerSet(){
        Numbers = new ArrayList<>();
        CheckRep();
    }

    private void CheckRep() {
        if(Numbers == null)
            throw new RuntimeException("Number must not contain NULL");
        if(Numbers.size() > 1){
            for (int i = 0; i < Numbers.size() - 1 ; i++) {
                if(Numbers.get(i) >= Numbers.get(i+1)){
                    throw new RuntimeException("Rep invariant violated!");
                }
            }
        }
    }

    /** add number in set
     * @param x number to be added.
    */
    public void add(Integer x) {
        if(!Numbers.contains(x) && Numbers != null && x != null){
            if (Numbers.size() == 0) {
                Numbers.add(x);
            }else{
                for (int i = 0; i < Numbers.size(); i++) {
                    if (x < Numbers.get(0)) {
                        Numbers.add(0,x);
                        break;
                    }else{
                        if(i == Numbers.size() - 1){
                        Numbers.add(x);
                        break;
                    }
                        if(Numbers.get(i) < x && x < Numbers.get(i+1)){
                        Numbers.add(i+1,x);
                        break;
                    }
                    }
                    
                }
            }
        }
        
        CheckRep();
    }

    /**
     * delete number in set
     * @param x number to be deleted.
     */
    public void remove(Integer x) {
        
        if(Numbers.contains(x) && x != null) {
            Numbers.remove(x);
        }       
        CheckRep();
    } 

    public String toString() {
        return Numbers.toString();
    }
}