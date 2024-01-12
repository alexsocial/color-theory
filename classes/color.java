package classes;

public class Color { //superclass
    private String hexCode;
    private String nearestColor;

    public Color(String hc){
        if (hc.startsWith("#")) {
            hc = hc.substring(1);
        }

        if (validateHex(hc)) {
            this.hexCode = hc.substring(0, 6);
        } else {
            // Handle invalid hex code (throw exception, log, or set to a default value)
            throw new IllegalArgumentException("Invalid hex code: " + hc);
        }
    }

    public Color(String r, String g, String b){
        this.hexCode = toHex(r,g,b);
    }

    public static boolean validateHex(String hc){ //use for any invalid hex codes
        if (hc == null || hc.length() != 6){
            return false;
        }

        String validChars = "[0-9A-Fa-f]+"; //use regex pattern
        
        return hc.matches(validChars); //then check if hc has all valid
    }

    public String toRGB(Color c){
        String r = c.hexCode.substring(0, 2);
        String g = c.hexCode.substring(2, 4); 
        String b = c.hexCode.substring(4, 6);

        int rCol = Integer.parseInt(r);
        int gCol = Integer.parseInt(g);
        int bCol = Integer.parseInt(b);

        //try to do o(n) pass

        return ("R: " + String.valueOf(rCol) + " G: " + String.valueOf(gCol) + " B: " + String.valueOf(bCol));

    }

    public String toHex(String r, String g, String b){
        int rCol = Integer.parseInt(r);
        int gCol = Integer.parseInt(g);
        int bCol = Integer.parseInt(b);

        return("#" + Integer.toHexString(rCol) + Integer.toHexString(gCol) + Integer.toHexString(bCol));
    }
}
