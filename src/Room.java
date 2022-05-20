import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private String roomName, roomDescription;
    private Map<String, Room> exits;
    private Map<String, Weapon> weapon;
    public enum Direction{
        NORTH,EAST,SOUTH,WEST;
    }
    public HashMap<Direction, Room> connection = new HashMap<>();


    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        exits = new HashMap<>();
        weapon = new HashMap<>();
    }

    void setExits(Room... exits){
        for (Room p : exits) this.exits.put(p.roomName, p);
    }

    public HashMap<Direction, Room> getConnection() {
        return connection;
    }


}
