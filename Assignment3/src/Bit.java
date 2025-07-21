
public class Bit {

    private boolean value;

    public Bit(boolean value){
        this.value = value;
        }

    public int toInt(){ 
        int ans = 0;
        if (value == true)
        	ans = 1;
    	return ans;

    }

    public String toString(){
        String ans = "";
        ans = ans + this.toInt();
        return ans;
    }
}

