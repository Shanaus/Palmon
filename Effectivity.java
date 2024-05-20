public class Effectivity {
    // Festelegung der Eigenschafen der Effectivity in Strings
    String initial_type;
    String target_type;
    String damage_factor;

    // Getter-Methoden für die Eigenschaften der Effectivity
    public String getInitial_Type()
    { return initial_type; }
    public String getTarget_Type()
    { return target_type; }
    public String getDamage_Factor()
    { return damage_factor; }

    // // Erstellung eines Konstruktors, um flexibel ein Effectivity-Objekt initialisieren zu können
    Effectivity(String _initial_type, String _target_type, String _damage_factor)
    {
        initial_type = _initial_type;
        target_type = _target_type;
        damage_factor = _damage_factor;
    }
}

