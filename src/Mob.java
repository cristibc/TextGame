import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Mob {

    public String name;
    public int hp;
    public int attack;

    public Mob(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }


//    public static void main(String... args) {
//        List<Mob> mobs = readMobsFromCSV("mobs.csv");
//
//        for (Mob m : mobs) {
//            System.out.println(m);
//        }
//    }



    public static java.util.List<Mob> readMobsFromCSV(String filename) {
        java.util.List<Mob> mobs = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8))
        {
            String line = br.readLine();
            while (line != null) {
                String[] stats = line.split(",");

                Mob mob = createMob(stats);
                mobs.add(mob);
                line = br.readLine();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return mobs;
    }


    private static Mob createMob (String[] metadata){
        String name = metadata[0];
        int hp = Integer.parseInt(metadata[1]);
        int attack = Integer.parseInt(metadata[2]);

        return new Mob(name,hp,attack);
    }

    @Override
    public String toString(){
        return "Mob [name=" + name + ", hp=" + hp + ", attack=" + attack + "]";
    }

        }

