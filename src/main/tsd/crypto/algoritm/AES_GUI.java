package main.tsd.crypto.algoritm;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Sizeable;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.commons.codec.binary.Hex;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.Sizeable.Unit;

public class AES_GUI extends VerticalLayout implements View {
    final TextField poleTekstu = new TextField();

    final TextField poleTekstu2 = new TextField();
    final Label runda = new Label();


    StringBuilder sb = new StringBuilder();
    HorizontalLayout horizontal = new HorizontalLayout();
    HorizontalLayout horizontal2 = new HorizontalLayout();
    HorizontalLayout horizontal3 = new HorizontalLayout();
    HorizontalLayout horizontal4 = new HorizontalLayout();
    int i = 1;
    VerticalLayout vertical = new VerticalLayout();
    VerticalLayout vertical2 = new VerticalLayout();
    VerticalLayout vertical3 = new VerticalLayout();

    VerticalLayout vertical4 = new VerticalLayout();
    VerticalLayout vertical5 = new VerticalLayout();
    VerticalLayout vertical6 = new VerticalLayout();
    VerticalLayout vertical7 = new VerticalLayout();
    VerticalLayout vertical8 = new VerticalLayout();
    VerticalLayout vertical9 = new VerticalLayout();

    byte[][] tmp = new byte[4][4];
    Navigator navigator;

    public AES_GUI() {


        addStyleName("AES_VSPACING");
        setSpacing(true);

        poleTekstu.setMaxLength(16);
        poleTekstu2.setMaxLength(32);
        poleTekstu.setValue("Tekst");
        poleTekstu2.setValue("Klucz");
        Button b = new Button("Licz",

                new Button.ClickListener() {
                    @Override

                    public void buttonClick(Button.ClickEvent event) {

                        if (poleTekstu2.getValue().length() == 16 || poleTekstu2.getValue().length() == 24 || poleTekstu2.getValue().length() == 32) {
                            i = 1;

                            display(poleTekstu.getValue().getBytes(), poleTekstu2.getValue().getBytes(), i);
                            addComponent(vertical);
                            runda.setValue("Runda " + String.valueOf(i));
                        } else poleTekstu2.setValue("Zła długość klucza");
                    }

                });

        Button b2 = new Button("|<",

                new Button.ClickListener() {
                    @Override

                    public void buttonClick(Button.ClickEvent event) {
                        i = 1;
                        display(poleTekstu.getValue().getBytes(), poleTekstu2.getValue().getBytes(), i);
                        addComponent(vertical);
                        runda.setValue("Runda " + String.valueOf(i));
                    }
                });

        Button b3 = new Button("<",


                new Button.ClickListener() {
                    @Override

                    public void buttonClick(Button.ClickEvent event) {
                        i--;
                        if (i < 1) {
                            i = 1;
                        }
                        display(poleTekstu.getValue().getBytes(), poleTekstu2.getValue().getBytes(), i);
                        addComponent(vertical);

                        runda.setValue("Runda " + String.valueOf(i));

                    }
                });

        Button b4 = new Button(">",


                new Button.ClickListener() {
                    @Override

                    public void buttonClick(Button.ClickEvent event) {
                        i++;
                        if (i > (poleTekstu2.getValue().length() / 4) + 6) {
                            i = (poleTekstu2.getValue().length() / 4) + 6;
                        }
                        display(poleTekstu.getValue().getBytes(), poleTekstu2.getValue().getBytes(), i);
                        addComponent(vertical);

                        runda.setValue("Runda " + String.valueOf(i));

                    }
                });


        Button b5 = new Button(">|",


                new Button.ClickListener() {
                    @Override

                    public void buttonClick(Button.ClickEvent event) {
                        i = (poleTekstu2.getValue().length() / 4) + 6;
                        if (i > (poleTekstu2.getValue().length() / 4) + 6) {
                            i = (poleTekstu2.getValue().length() / 4) + 6;
                        }
                        display(poleTekstu.getValue().getBytes(), poleTekstu2.getValue().getBytes(), i);
                        addComponent(vertical);

                        runda.setValue("Runda " + String.valueOf(i));

                    }
                });

        runda.setWidth("105px");
        runda.setStyleName("Wyniki");
        GridLayout grid = new GridLayout(3, 4);
        GridLayout grid2 = new GridLayout(1, 1);
        GridLayout grid3 = new GridLayout(1, 1);
        horizontal.addComponents(poleTekstu, poleTekstu2, b);
        horizontal4.addComponents(runda, b2, b3, b4, b5);
        //vertical8.addComponents(horizontal, horizontal3);
        // horizontal.setWidth("100%");


        grid2.setHeight("150px");
        grid3.setHeight("150px");
        grid2.addComponent(horizontal2, 0, 0);

        grid.addComponent(horizontal, 0, 3);
        grid.setComponentAlignment(horizontal, Alignment.TOP_CENTER);
        grid.addComponent(horizontal4, 0, 2);
        grid.setComponentAlignment(horizontal4, Alignment.MIDDLE_LEFT);


        //grid.addComponent(horizontal3,0,2,1,2)

        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        grid.setStyleName("gridlayout");
        addComponent(grid3);
        addComponent(grid2);
        addComponent(grid);
        //setComponentAlignment(grid, Alignment.MIDDLE_CENTER);

        //addComponent(horizontal);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }


    private void display(byte[] in, byte[] k, int round) {

        byte[][] encTmp = AES.encrypt(in, k);
        byte[][] roundKeyTmp = AES.generateSubkeys(k);
        byte[][] roundKeyTmp2 = new byte[4][4];
        int b = 0;

        Label tekst = new Label();
        Label tekst2 = new Label();
        Label tekst3 = new Label();
        Label tekst4 = new Label();
        Label tekst5 = new Label();
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
        Label tekst21 = new Label("6");
        Label tekst22 = new Label();
        Label tekst23 = new Label();
        Label tekst24 = new Label();
        Label tekst25 = new Label("1");

        Label tekst26 = new Label("Start of round");
        Label tekst27 = new Label("SubBytes");
        Label tekst28 = new Label("ShiftRows");
        Label tekst29 = new Label("MixColumns");
        Label tekst30 = new Label("RoundKey");
        Label tekst31 = new Label("Result");

        Label tekst32 = new Label(" ");
        Label tekst33 = new Label(" ");
        Label tekst34 = new Label(" ");
        Label tekst35 = new Label(" ");
        Label tekst36 = new Label(" ");
        Label tekst37 = new Label(" ");


        if (in.toString().length() % 16 == 0) {
            b = (in.toString().length() / 16) * 16;
        } else b = ((in.toString().length() / 16) + 1) * 16;

        byte[] enc = new byte[b];

        for (int j = 0; j < b; j++) {
            enc[j] = encTmp[0][j + ((round - 1) * 16)];
        }
        for (int i = 0; i < 16; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst2.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst3.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst4.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst.addStyleName("Wyniki");
        tekst2.addStyleName("Wyniki");
        tekst3.addStyleName("Wyniki");
        tekst4.addStyleName("Wyniki");
        tekst26.setStyleName("Wyniki");
        vertical2.setHeight("100%");
        vertical2.removeAllComponents();
        vertical2.addComponents(tekst26, tekst32, tekst, tekst2, tekst3, tekst4);
        vertical2.setComponentAlignment(tekst26, Alignment.MIDDLE_CENTER);
        //tekst26.setWidth(Sizeable.SIZE_UNDEFINED, Unit.PIXELS);
        tekst26.addStyleName("Podpis");

        for (int j = 0; j < b; j++) {
            enc[j] = encTmp[1][j + ((round - 1) * 16)];
        }
        for (int i = 0; i < 16; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst5.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst6.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst7.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst8.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst5.setSizeUndefined();
        tekst5.addStyleName("Wyniki");
        tekst6.addStyleName("Wyniki");
        tekst7.addStyleName("Wyniki");
        tekst8.addStyleName("Wyniki");
        tekst27.setStyleName("Wyniki");
        vertical3.setHeight("100%");

        vertical3.removeAllComponents();
        vertical3.addComponents(tekst27, tekst33, tekst5, tekst6, tekst7, tekst8);
        vertical3.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);


        for (int j = 0; j < b; j++) {
            enc[j] = encTmp[2][j + ((round - 1) * 16)];
        }
        for (int i = 0; i < 16; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst9.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst10.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst11.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst12.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst9.addStyleName("Wyniki");
        tekst10.addStyleName("Wyniki");
        tekst11.addStyleName("Wyniki");
        tekst12.addStyleName("Wyniki");
        tekst28.setStyleName("Wyniki");
        vertical4.setHeight("100%");
        vertical4.removeAllComponents();
        vertical4.addComponents(tekst28, tekst34, tekst9, tekst10, tekst11, tekst12);
        vertical4.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        for (int j = 0; j < b; j++) {
            enc[j] = encTmp[3][j + ((round - 1) * 16)];
        }
        for (int i = 0; i < 16; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst13.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst14.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst15.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst16.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst13.addStyleName("Wyniki");
        tekst14.addStyleName("Wyniki");
        tekst15.addStyleName("Wyniki");
        tekst16.addStyleName("Wyniki");
        tekst29.addStyleName("Wyniki");

        if (round == (k.length / 4) + 6) {
            tekst13.setValue("** ** ** ** ");
            tekst14.setValue("** ** ** ** ");
            tekst15.setValue("** ** ** ** ");
            tekst16.setValue("** ** ** ** ");
        }
        vertical5.setHeight("100%");
        vertical5.removeAllComponents();
        vertical5.addComponents(tekst29, tekst35, tekst13, tekst14, tekst15, tekst16);
        vertical5.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                roundKeyTmp2[j][i] = roundKeyTmp[i + (4 * round)][j];
            }
        }

        for (int i = 0; i < 16; i++) {
            tmp[i / 4][i % 4] = roundKeyTmp2[i / 4][i % 4];
        }

        tekst17.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst18.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst19.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst20.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst17.addStyleName("Wyniki");
        tekst18.addStyleName("Wyniki");
        tekst19.addStyleName("Wyniki");
        tekst20.addStyleName("Wyniki");
        tekst30.setStyleName("Wyniki");
        vertical6.setHeight("100%");
        vertical6.removeAllComponents();
        vertical6.addComponents(tekst30, tekst36, tekst17, tekst18, tekst19, tekst20);
        vertical6.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);


        for (int j = 0; j < b; j++) {
            enc[j] = encTmp[4][j + ((round - 1) * 16)];
        }
        for (int i = 0; i < 16; i++) {
            tmp[i / 4][i % 4] = enc[(i % 4 * 4 + i / 4)];
        }
        tekst21.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[0]))));
        tekst22.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[1]))));
        tekst23.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[2]))));
        tekst24.setValue(spacing(String.valueOf(Hex.encodeHexString(tmp[3]))));
        tekst21.addStyleName("Wyniki");
        tekst22.addStyleName("Wyniki");
        tekst23.addStyleName("Wyniki");
        tekst24.addStyleName("Wyniki");
        tekst31.setStyleName("Wyniki");
        vertical7.setHeight("100%");
        vertical7.removeAllComponents();
        vertical7.addComponents(tekst31, tekst37, tekst21, tekst22, tekst23, tekst24);
        vertical7.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        //horizontal2.setSpacing(true);


        horizontal2.removeAllComponents();
        //horizontal2.addStyleName("v-horizontal");
        vertical2.setSpacing(true);
        vertical3.setSpacing(true);
        vertical4.setSpacing(true);
        vertical5.setSpacing(true);
        vertical6.setSpacing(true);
        vertical7.setSpacing(true);

        vertical2.addStyleName("AES_VSPACING");
        vertical3.addStyleName("AES_VSPACING");
        vertical4.addStyleName("AES_VSPACING");
        vertical5.addStyleName("AES_VSPACING");
        vertical6.addStyleName("AES_VSPACING");
        vertical7.addStyleName("AES_VSPACING");

        horizontal2.setSpacing(true);
        horizontal2.addStyleName("AES_VSPACING");
        horizontal2.addComponents(vertical2, vertical3, vertical4, vertical5, vertical6, vertical7);



            /*vertical.addComponent(tekst3);
        vertical.addComponent(tekst4);*/

    }

    public String spacing(String in) {

        int interval = 2;
        char separator = ' ';

        StringBuilder sb = new StringBuilder(in);

        for (int i = 0; i < in.length() / interval; i++) {
            sb.insert(((i + 1) * interval) + i, separator);
        }

        String withDashes = sb.toString();
        return withDashes;
    }
}

