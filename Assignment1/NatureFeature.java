public class NatureFeature 
{
    private char featureType;
    private String featureName;
    private int spacePenalty;

    public NatureFeature() 
    {
        featureType = ' ';
        featureName = "NULL";
        spacePenalty = 0;
    }

    /**
     * 
     * @param _type    feature type of the naturefeature
     * @param _name    feature name of the naturefeature
     * @param _penalty space penalty of the naturefeature
     */
    public NatureFeature(char _type, String _name, int _penalty) 
    {
        featureType = _type;
        featureName = _name;
        spacePenalty = _penalty;
    }

    public char getFeatureType() 
    {
        return featureType;
    }

    public String getFeatureName() 
    {
        return featureName;
    }

    public int getSpacePenalty() 
    {
        return spacePenalty;
    }

    public void setFeatureType(char _type) 
    {
        featureType = _type;
    }

    public void setFeatureName(String _name) 
    {
        featureName = _name;
    }

    public void setSpacePenalty(int _space) 
    {
        spacePenalty = _space;
    }

    public String toString() 
    {
        return "NatureFeature: featureType = " + featureType + ", featureName = " + featureName + ", spacePenalty = " + spacePenalty;
    }
}