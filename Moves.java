class Moves {
    // Festelegung der Eigenschaften der Moves in Strings
    String id;
    String name;
    String damage;
    String max_usage;
    String accuracy;
    String type;

    //Getter-Methoden für die Eigenschaften der Moves
    public String getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getDamage()
    {
        return damage;
    }
    public String getMax_Usage()
    {
        return max_usage;
    }
    public String getAccuracy()
    {
        return accuracy;
    }
    public String getType()
    {
        return type;
    }

    // Erstellung eines Konstruktors, um flexibel ein Move-Objekt initialisieren zu können
    Moves(String _id, String _name, String _damage, String _max_usage, String _accuracy, String _type)
    {
        this.id = _id;
        this.name = _name;
        this.damage = _damage;
        this.max_usage = _max_usage;
        this.accuracy = _accuracy;
        this.type = _type;
    }
}
