public class BitVector {
    private Bit[] bits;
    
    public BitVector(String s) {
        if (s == "" | s == null)
        	throw new IllegalArgumentException("s cannot be empty");
        for (int i=0; i < s.length(); i++) 
        	if("0123456789".indexOf(s.charAt(i)) > 1)
        		throw new IllegalArgumentException("not all the chars are legal at the base of 2");
        char lastChar = s.charAt(s.length()-1);
        if("0123456789".indexOf(lastChar) == 0 & s.length() != 1)
        	throw new IllegalArgumentException("the msb cannot be 0");        
    	
        this.bits = new Bit[s.length()];
        for (int i=0; i < s.length(); i++)
        	if (s.charAt(i) == '1')
        		bits[i] = new Bit(true);
        	else
        		bits[i] = new Bit(false);
    }

    public String toString() {
        String ans = "";
        String binary = "";
        for (int i=0; i < bits.length; i++)
        	binary = binary + bits[i].toString();
        String decimal = NumericalString.binary2Decimal(binary);
        for(int i=decimal.length()-1; i>=0 ; i--)
        	ans = ans + decimal.charAt(i);
        return ans;
    }

}
