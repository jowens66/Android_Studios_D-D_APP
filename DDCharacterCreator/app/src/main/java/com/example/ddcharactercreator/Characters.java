package com.example.ddcharactercreator;

public class Characters {

    private int _id;
    private String _charactername;

    public Characters(String charactername){
        this._charactername = charactername;
    }

    public void set_id(int _id){
        this._id = _id;
    }

    public void set_charactername(String _charactername){
        this._charactername = _charactername;
    }

    public int get_id(){
        return _id;
    }

    public String get_charactername(){
        return _charactername;
    }
}
