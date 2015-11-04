public class Gear{
    String name, type, mod1Stat, mod2Stat, mod3Stat;
    int lvlReq, mod1, mod2, mod3;
    public Gear(String name, String type, int lvlReq, int mod1, String mod1Stat, int mod2, String mod2Stat, int mod3, String mod3Stat){
        this.name = name;
        this.type = type;
        this.lvlReq = lvlReq;
        this.mod1 = mod1;
        this.mod1Stat = mod1Stat;
        this.mod2 = mod2;
        this.mod2Stat = mod2Stat;
        this.mod3 = mod3;
        this.mod3Stat = mod3Stat;
    }
    public static void main(String[] args){
        
    }
 
  
        
   //all items available to the player in the game
       
    //headgear
    public static Gear headgear0 = new Gear("leather helm", "headgear", 0, 1, "AC",  0, "null", 0, "null");
       
    //chestpieces
    public static Gear chestpiece0 = new Gear("ragged tunic", "chestpiece", 0, 1, "AC",  2, "test", 0, "null");
       
    //Bracers
    public static Gear bracers0 = new Gear("cloth wristband", "bracers", 0, 1, "AC",  2, "test", 4, "test");
       
    //Gloves
    public static Gear gloves0 = new Gear("fluffy mittens", "gloves", 0, 1, "AC",  0, "null", 0, "null");
       
    //Rings
    public static Gear ring0 = new Gear("rusted ring", "ring", 0, 1, "int",  0, "null", 0, "null");
    
    //Leggings
    public static Gear leggings0 = new Gear("commoner shorts", "leggings", 0, 1, "AC",  0, "null", 0, "null");
       
    //Boots
    public static Gear boots0 = new Gear("socks with sandals", "boots", 0, 1, "AC",  0, "null", 0, "null");
       
    //Weapons
    public static Gear weapon0 = new Gear("wooden stick", "weapon",  0, 1, "STR",  0, "null", 0, "null");
   
}


