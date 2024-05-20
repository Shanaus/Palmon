class Palmon_move
{
    // Festlegung der Eigenschaften der Palmon_moves in Strings
    String palmon_id;
    String move_id;
    String learned_on_level;

    // Getter-Methoden für die Eigenschaften der Palmon_moves
    public String getPalmon_ID()
    {
        return palmon_id;
    }
    public String getMove_id()
    {
        return move_id;
    }
    public String getLearned_On_Level()
    {
        return learned_on_level;
    }

    // Erstellung eines Konstruktors, um flexibel ein Palmon_move-Objekt initialisieren zu können
    Palmon_move(String _palmon_id, String _move_id, String _learned_on_Level) {
        this.palmon_id = _palmon_id;
        this.move_id = _move_id;
        this.learned_on_level = _learned_on_Level;
    }
}