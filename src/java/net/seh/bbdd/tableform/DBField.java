package net.seh.bbdd.tableform;


/**
 */
public class DBField
{
    /** Nombre del campo */
    String sName;
    /** Tipo del campo */
    String sType;
    /** Tama&ntilde;o del campo */
    int size=-1;

    /**
     * Constructor
     *
     * @param sName Nombre del campo
     * @param sType Tipo del campo
     * @param size Tama&ntilde;o del campo
     */
    DBField(String sName, String sType, int size)
    {
        this.sName=sName;
        this.sType=sType;
        this.size=size;
    }

    //--´GET's y SET's
    public String getName()
    { return this.sName; }
    public String getType()
    { return this.sType; }
    public int getSize()
    { return this.size; }

    /** Representaci&oacute;n del objeto */
    public String toString()
    {
        return sName+" "+sType+"("+size+")";
    }
}  //-- eoClass

