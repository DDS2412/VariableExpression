
package model.operations;

import model.Node;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface Operation {
    public Operation getOppositeOperation();

    public int getOrder();

    public String getDefaultValue();

    public default boolean isSwiping(){
        return false;
    }
}

