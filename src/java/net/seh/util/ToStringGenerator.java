package net.seh.util;

import java.lang.reflect.*;

/**
 */
public class ToStringGenerator
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Provide the class name as the command line argument");
            System.exit(0);
        }

        try {
            Class targetClass = Class.forName(args[0]);

            if (!targetClass.isPrimitive() && targetClass != String.class)
            {
                Field fields[] = targetClass.getDeclaredFields();
                Class cSuper = targetClass.getSuperclass(); // Retrieving the super class
                output("StringBuffer buffer = new StringBuffer(500);"); // Buffer Construction
                if (cSuper != null && cSuper != Object.class) {
                    output("buffer.append(super.toString());"); // Super class's toString()
                }

                for (int j = 0; j < fields.length; j++) {
                    output("buffer.append(\"" + fields[j].getName() + " = \");"); // Append Field name
                    if (fields[j].getType().isPrimitive() || fields[j].getType() == String.class) // Check for a primitive or string            
                        output("buffer.append(this." + fields[j].getName() + ");"); // Append the primitive field value
                    else {
                        /* It is NOT a primitive field so this requires a check for the NULL value for the aggregated object */
                        output("if ( this." + fields[j].getName() + "!= null )" );
                        output("buffer.append(this." + fields[j].getName() + ".toString());");
                        output("else buffer.append(\"NULL\"); ");
                    } // end of else
                } // end of for loop

                output("return buffer.toString();");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found in the class path");
            System.exit(0);
        }
    }

    /**
     */
    private static void output(String data)
    {
        System.out.println(data);
    }
}