package main.tsd.crypto.algoritm;


import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.apache.commons.codec.binary.Hex;

public class AES_UI extends UI implements Button.ClickListener {

    private final TextField poleTekstu = new TextField();
    private final TextField poleTekstu2 = new TextField();
    private final String startOfRound = "";
    private final String subBytes = "";
    private final String shiftRows = "";
    private final String mixColumns = "";
    private final String roundKey = "";
    private final String result = "";
    StringBuilder sb = new StringBuilder();
    HorizontalLayout horizontal = new HorizontalLayout();
    HorizontalLayout horizontal2 = new HorizontalLayout();
    HorizontalLayout horizontal3 = new HorizontalLayout();
    int i,j,k,l = 0;
    public VerticalLayout vertical = new VerticalLayout();
    public VerticalLayout vertical2 = new VerticalLayout();
    public VerticalLayout vertical3 = new VerticalLayout();
    public VerticalLayout vertical4 = new VerticalLayout();
    public VerticalLayout vertical5 = new VerticalLayout();
    public VerticalLayout vertical6 = new VerticalLayout();
    public VerticalLayout vertical7 = new VerticalLayout();
    byte[][] tmp = new byte[4][4];

    public String tablica;
    @Override
    public void init(VaadinRequest request) {

        //  VerticalLayout layout = new VerticalLayout();


        Button b = new Button("Generuj");
        Button b2 = new Button("|<");
        Button b3 = new Button("<");
        Button b4 = new Button(">");
        Button b5 = new Button(">|");


        //b2.addListener();

        horizontal.addComponent(poleTekstu);
        horizontal.addComponent(poleTekstu2);
        horizontal.addComponent(b);

        horizontal3.addComponents(b2,b3,b4,b5);
        vertical.addComponents(horizontal);
        setContent(vertical);


        }

    public void buttonClick(Button.ClickEvent event)
    {
        byte[][] encTmp = AES.encrypt(poleTekstu.getValue().getBytes(), poleTekstu2.getValue().getBytes());

        Label tekst = new Label();
        Label tekst2 = new Label();
        Label tekst3 = new Label();
        Label tekst4 = new Label();
        Label tekst6 = new Label();
        Label tekst7 = new Label();
        Label tekst8 = new Label();
        Label tekst9 = new Label();
        Label tekst10 = new Label();
        Label tekst11 = new Label();
        Label tekst12 = new Label();
        Label tekst13 = new Label();
        Label tekst14 = new Label();
        Label tekst15 = new Label();
        Label tekst16 = new Label();
        Label tekst17 = new Label();
        Label tekst18 = new Label();
        Label tekst19 = new Label();
        Label tekst20 = new Label();
        Label tekst5 = new Label();


        if (poleTekstu.getValue().length()%16 == 0)
        {
            i=(poleTekstu.getValue().length()/16)*16;
        }else i = ((poleTekstu.getValue().length()/16)+1) * 16;

        byte[] enc = new byte[i];

        for (int j = 0; j < i ; j++ )
        {
            enc[j] = encTmp[0][j + 144 ];
        }
        for (int i = 0; i<16 ; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst2.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst3.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst4.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst.addStyleName( "h1" );
        tekst2.addStyleName( "h1" );
        tekst3.addStyleName( "h1" );
        tekst4.addStyleName( "h1" );

        vertical2.addComponents(tekst,tekst2,tekst3,tekst4);


        for (int j = 0; j < i ; j++ )
        {
            enc[j] = encTmp[1][j + 144 ];
        }
        for (int i = 0; i<16 ; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst5.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst6.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst7.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst8.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst5.addStyleName( "h1" );
        tekst6.addStyleName( "h1" );
        tekst7.addStyleName( "h1" );
        tekst8.addStyleName( "h1" );
        vertical3.addComponents(tekst5,tekst6,tekst7,tekst8);

        for (int j = 0; j < i ; j++ )
        {
            enc[j] = encTmp[2][j + 144 ];
        }
        for (int i = 0; i<16 ; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst9.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst10.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst11.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst12.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst9.addStyleName( "h1" );
        tekst10.addStyleName( "h1" );
        tekst11.addStyleName( "h1" );
        tekst12.addStyleName( "h1" );
        vertical4.addComponents(tekst9,tekst10,tekst11,tekst12);

        for (int j = 0; j < i ; j++ )
        {
            enc[j] = encTmp[3][j + 144 ];
        }
        for (int i = 0; i<16 ; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst13.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst14.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst15.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst16.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst13.addStyleName( "h1" );
        tekst14.addStyleName( "h1" );
        tekst15.addStyleName( "h1" );
        tekst16.addStyleName( "h1" );
        vertical5.addComponents(tekst13,tekst14,tekst15,tekst16);


        for (int j = 0; j < i ; j++ )
        {
            enc[j] = encTmp[4][j + 144 ];
        }
        for (int i = 0; i<16 ; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst17.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst18.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst19.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst20.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst17.addStyleName( "h1" );
        tekst18.addStyleName( "h1" );
        tekst19.addStyleName( "h1" );
        tekst20.addStyleName( "h1" );
        vertical6.addComponents(tekst17,tekst18,tekst19,tekst20);

        horizontal2.setSpacing(true);
        horizontal2.addStyleName("spacing");

        horizontal2.addComponents(vertical2,vertical3,vertical4,vertical5,vertical6);
        vertical.addComponents(horizontal2,horizontal3);

        /*vertical.addComponent(tekst3);
        vertical.addComponent(tekst4);*/


    }
    private String spacing (String in)
    {

        int interval = 2;
        char separator = ' ';

        StringBuilder sb = new StringBuilder(in);

        for(int i = 0; i < in.length() / interval; i++) {
            sb.insert(((i + 1) * interval) + i, separator);
        }

        String withDashes = sb.toString();
        return  withDashes;
    }
}