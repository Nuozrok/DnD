public class Gear{
    String name, type;
    int lvlReq, mod1, mod2, mod3;
    public Gear(String name, String type, int lvlReq, int mod1, int mod2, int mod3){
        this.name = name;
        this.type = type;
        this.lvlReq = lvlReq;
        this.mod1 = mod1;
        this.mod2 = mod2;
        this.mod3 = mod3;
    }
    public static void main(String[] args){
        
    }
 
  
        
   //all items available to the player in the game
       
    //headgear
    public static Gear headgear0 = new Gear("a leather helm", "headgear", 0, 1, 0, 0);
       
    //chestpieces
    public static Gear chestpiece0 = new Gear("a ragged tunic", "chestpiece", 0, 1, 0, 0);
       
    //Bracers
    public static Gear bracers0 = new Gear("a cloth wristband", "bracer", 0, 1, 0, 0);
       
    //Gloves
    public static Gear gloves0 = new Gear("fluffy mittens", "gloves", 0, 1, 0, 0);
       
    //Rings
    public static Gear ring0 = new Gear("a rusted ring", "ring", 0, 1, 0, 0);
    
    //Leggings
    public static Gear leggings0 = new Gear("commoner shorts", "leggings", 0, 1, 0, 0);
       
    //Boots
    public static Gear boots0 = new Gear("socks with sandals", "boots", 0, 1, 0, 0);
       
    //Weapons
    public static Gear weapon0 = new Gear("a wooden stick", "weapon", 0, 1, 0, 0);
   
}


