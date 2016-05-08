package tilda.parsing.parts;

import com.google.gson.annotations.SerializedName;

public class Documentation {
    @SerializedName("graph") public String  _Graph;
    public Documentation(){
    	this._Graph = "complex"; // default value
    }

    public Documentation(String _Graph){
    	// TODO /mohan, to check for _Graph if its value is 'complex' or 'simple'
    	this._Graph = _Graph; // default value
    }
}
