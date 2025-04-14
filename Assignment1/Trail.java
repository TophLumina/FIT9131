import java.util.HashMap;

public class Trail 
{
    public static HashMap<Character, NatureFeature> natureFeatureLUT;
    public static NatureFeature defalutNatureFeature;
    private NatureFeature[] natureTrail;

    static 
    {
        natureFeatureLUT = new HashMap<Character, NatureFeature>(4);
        natureFeatureLUT.put('c', new NatureFeature('c', "Creek", -2));
        natureFeatureLUT.put('b', new NatureFeature('b', "Bridge", 4));
        natureFeatureLUT.put('f', new NatureFeature('f', "Fallen tree", -3));
        natureFeatureLUT.put('l', new NatureFeature('l', "Landslide", -5));

        defalutNatureFeature = new NatureFeature();
    }

    public Trail() 
    {
        natureTrail = null;
    }

    /**
     * 
     * @param _trail    nature trail in char array
     */
    public Trail(char[] _trail) 
    {
        natureTrail = new NatureFeature[_trail.length];

        for (int i = 0; i < _trail.length; ++i) 
        {
            if (natureFeatureLUT.containsKey(_trail[i]))
                natureTrail[i] = natureFeatureLUT.get(_trail[i]);
            else
                natureTrail[i] = defalutNatureFeature;
        }
    }

    public NatureFeature[] getNatureTrail() 
    {
        return natureTrail;
    }

    public void setNatureTrail(NatureFeature[] _trail) 
    {
        natureTrail = _trail;
    }

    public String toString() 
    {
        String desc = "Trail: natureTrail = [";
        for (NatureFeature feature : natureTrail)
            desc += "(" + feature.toString() + ")\n";

        return desc + "]";
    }
}