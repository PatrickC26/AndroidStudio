package tw.cgu.b0921251_mcs.sql_5g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

public class SensorListContainer
{

    private ArrayList<SensorStruct> jlist_items;

    //item
    public ArrayList<SensorStruct> getListItems()
    {
        return jlist_items;
    }

    public SensorStruct getoneJL(int index)
    {
        return jlist_items.get(index);
    }

    public SensorListContainer()
    {
        jlist_items = new ArrayList<SensorStruct>();
    }

    public void addRXMLItem(SensorStruct item)
    {
        jlist_items.add(item);
    }
}
