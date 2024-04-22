package tw.cgu.b0921251_mcs.sql_5g;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class SensorListHandler extends DefaultHandler
{
    //tag
    private String TAG = "RentListHandler";

    private final static int ID = 1;
    private final static int S1 = 2;
    private final static int S2 = 3;
    private final static int S3 = 4;
    private final static int S4 = 5;
    private final static int S5 = 6;
    private final static int RDATE= 7;

    private SensorStruct jls;
    private SensorListContainer jlcs;

    private int type;

    public SensorListContainer getContainer()
    {
        return jlcs;
    }

    public SensorStruct getJListStruct()
    {
        return jlcs.getoneJL(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String s = new String(ch, start, length);

        switch (type)
        {
            case ID:
                jls.id = s;
                type = 0;
                break;
            case S1:
                jls.s1 = s;
                type = 0;
                break;
            case S2:
                jls.s2 = s;
                type = 0;
                break;
            case S3:
                jls.s3 = s;
                type = 0;
                break;
            case S4:
                jls.s4 = s;
                type = 0;
                break;
            case S5:
                jls.s5 = s;
                type = 0;
                break;
            case RDATE:
                jls.rdate = s;
                type = 0;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if (localName.toLowerCase().equals("item"))
        {
            jlcs.addRXMLItem(jls);
        }
    }

    @Override
    public void startDocument() throws SAXException
    {
        jlcs = new SensorListContainer();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException
    {
        if (localName.toLowerCase().equals("item"))
        {
            jls = new SensorStruct();
            return;
        }
        else if (localName.toLowerCase().equals("id"))
        {
            type = ID;
            return;
        }
        else if (localName.toLowerCase().equals("s1"))
        {
            type = S1;
            return;
        }
        else if (localName.toLowerCase().equals("s2"))
        {
            type = S2;
            return;
        }
        else if (localName.toLowerCase().equals("s3"))
        {
            type = S3;
            return;
        }
        else if (localName.toLowerCase().equals("s4"))
        {
            type = S4;
            return;
        }
        else if (localName.toLowerCase().equals("s5"))
        {
            type = S5;
            return;
        }
        else if (localName.toLowerCase().equals("rdate"))
        {
            type = RDATE;
            return;
        }
        type = 0;
    }

}