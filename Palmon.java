import java.util.ArrayList;

public class Palmon
{
    // Festlegung der Eigenschaften der Palmons in Strings
String id;
String name;
String height;
String weight;
String type1;
String type2;
String hp;
String attack;
String defense;
String speed;

//Getter-Methoden für die Eigenschaften der Palmons
    public String getId() {return id;}
    public String getName() {return name;}
    public String getHeight()
    {
        return height;
    }
    public String getWeight()
    {
        return weight;
    }
    public String getType1()
    {
        return type1;
    }
    public String getType2()
    {
        return type2;
    }
    public String getHp() { return hp; }
    public String getAttack()
    {
        return attack;
    }
    public String getSpeed()
    {
        return speed;
    }

    // Erstellung eines Konstruktors, um flexibel ein Palmon-Objekt initialisieren zu können
Palmon(String _id, String _name, String _height, String _weight, String _type1, String _type2, String _hp, String _attack, String _defense, String _speed) {
    this.id = _id;
    this.name = _name;
    this.height = _height;
    this.weight = _weight;
    this.type1 = _type1;
    this.type2 = _type2;
    this.hp = _hp;
    this.attack = _attack;
    this.defense = _defense;
    this.speed = _speed;
}

}
