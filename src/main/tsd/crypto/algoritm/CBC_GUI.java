package main.tsd.crypto.algoritm;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;
import java.math.BigInteger;

/**
 * Created by Kwasior on 2015-12-25.
 */
public class CBC_GUI extends HorizontalLayout implements View {
    private final TextField tekstPole = new TextField();
    private final TextField tekstPole2 = new TextField();
    private final TextField tekstPole3 = new TextField();
    private final TextField tekstPole4 = new TextField();
    private final TextField kluczPole = new TextField();
    private final TextField ivPole = new TextField();
    private final TextArea calytekstPole = new TextArea();
    private final Label xorPole = new Label();
    private final Label xorPole2 = new Label();
    private final Label xorPole3 = new Label();
    private final Label xorPole4 = new Label();
    private final Panel xorPanel = new Panel();
    private final Panel xorPanel2 = new Panel();
    private final Panel xorPanel3 = new Panel();
    private final Panel xorPanel4 = new Panel();
    private final Label wynikPole = new Label();
    private final Label wynikPole2 = new Label();
    private final Label wynikPole3 = new Label();
    private final Label wynikPole4 = new Label();
    private final Panel wynikPanel = new Panel();
    private final Panel wynikPanel2 = new Panel();
    private final Panel wynikPanel3 = new Panel();
    private final Panel wynikPanel4 = new Panel();
    private final Label tekstHexPole = new Label();
    private final Label tekstHexPole2 = new Label();
    private final Label tekstHexPole3 = new Label();
    private final Label tekstHexPole4 = new Label();
    private final Label ivHexPole = new Label();


    private final Panel tekstHexPanel = new Panel();
    private final Panel tekstHexPanel2 = new Panel();
    private final Panel tekstHexPanel3 = new Panel();
    private final Panel tekstHexPanel4 = new Panel();
    private final Panel ivHexPanel = new Panel();


    public String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
    public FileResource resource = new FileResource(new File(basepath + "/WEB-INF/images/EkCBC.png"));
    public FileResource resource2 = new FileResource(new File(basepath + "/WEB-INF/images/xorCBC.png"));
    public FileResource resource3 = new FileResource(new File(basepath + "/WEB-INF/images/arrowCBC.png"));
    public FileResource resource4 = new FileResource(new File(basepath + "/WEB-INF/images/xorCBC2.png"));

    Image image = new Image("", resource);
    Image image2 = new Image("", resource);
    Image image3 = new Image("", resource);
    Image image4 = new Image("", resource);

    Image image5 = new Image("", resource4);
    Image image6 = new Image("", resource2);
    Image image7 = new Image("", resource2);
    Image image8 = new Image("", resource2);

    Image image9 = new Image("", resource3);
    Image image10 = new Image("", resource3);
    Image image11 = new Image("", resource3);
    Image image12 = new Image("", resource3);

    public CBC_GUI() {


        //calytekstPole.setResponsive(true);


        HorizontalLayout horizontal = new HorizontalLayout();
        //horizontal.addComponents(tekstPole, tekstPole2, tekstPole3, tekstPole4);


        HorizontalLayout horizontal2 = new HorizontalLayout();
        //horizontal2.addComponents(wynikPole, wynikPole2, wynikPole3, wynikPole4);

        HorizontalLayout horizontal3 = new HorizontalLayout();
        HorizontalLayout horizontal4 = new HorizontalLayout();


        VerticalLayout vertical = new VerticalLayout();


        VerticalLayout vertical2 = new VerticalLayout();
        //vertical.addComponents(horizontal,horizontal4,  horizontal3,horizontal2 );

        VerticalLayout vertical3 = new VerticalLayout();
        VerticalLayout vertical4 = new VerticalLayout();
        VerticalLayout vertical5 = new VerticalLayout();
        VerticalLayout vertical6 = new VerticalLayout();
        VerticalLayout vertical7 = new VerticalLayout();
        VerticalLayout vertical8 = new VerticalLayout();
        VerticalLayout vertical9 = new VerticalLayout();

        vertical3.setWidth("135px");
        vertical5.setWidth("135px");
        vertical7.setWidth("135px");
        vertical9.setWidth("85px");

        tekstPole.setWidth("120px");
        tekstPole2.setWidth("120px");
        tekstPole3.setWidth("120px");
        tekstPole4.setWidth("120px");
        calytekstPole.setWidth("120px");
        calytekstPole.setWordwrap(true);
        calytekstPole.setMaxLength(64);
        ivPole.setValue("Wektor");
        kluczPole.setValue("Klucz");
        calytekstPole.setValue("Tekst do zaszyfrowania");
        tekstPole.setMaxLength(16);
        tekstPole2.setMaxLength(16);
        tekstPole3.setMaxLength(16);
        tekstPole4.setMaxLength(16);

        setSpacing(true);
        addStyleName("CBC_VSPACING");
        addComponents(vertical, vertical2);

        Button b = new Button("Licz",
                new Button.ClickListener() {
                    @Override

                    public void buttonClick(Button.ClickEvent event) {

                        if (kluczPole.getValue().length() == 16 || kluczPole.getValue().length() == 24 || kluczPole.getValue().length() == 32) {
                            if (ivPole.getValue().length() == 16) {
                                String[] calytekstArray = calytekstPole.getValue().split("");
                                for (int i = 0; i < calytekstArray.length; i++) {
                                    if (i < 17) {
                                        String pole1;
                                        pole1 = calytekstPole.getValue().substring(0, getMin(calytekstPole.getValue().length(), 16));
                                        tekstPole.setValue(pole1);

                                    }
                                    if (i < 33 && i >= 16) {
                                        String pole1;
                                        pole1 = calytekstPole.getValue().substring(16, getMin(calytekstPole.getValue().length(), 32));
                                        tekstPole2.setValue(pole1);

                                    }
                                    if (i < 49 && i >= 32) {
                                        String pole1;
                                        pole1 = calytekstPole.getValue().substring(32, getMin(calytekstPole.getValue().length(), 48));
                                        tekstPole3.setValue(pole1);

                                    }
                                    if (i < 65 && i >= 48) {

                                        String pole1;
                                        pole1 = calytekstPole.getValue().substring(48, getMin(calytekstPole.getValue().length(), 64));
                                        tekstPole4.setValue(pole1);


                                    }
                                }
                                if (calytekstPole.getValue().length() == 0) {
                                    tekstPole.setValue("");
                                    tekstPole2.setValue("");
                                    tekstPole3.setValue("");
                                    tekstPole4.setValue("");
                                } else if (calytekstPole.getValue().length() <= 16) {
                                    tekstPole2.setValue("");
                                    tekstPole3.setValue("");
                                    tekstPole4.setValue("");
                                } else if (calytekstPole.getValue().length() <= 32) {

                                    tekstPole3.setValue("");
                                    tekstPole4.setValue("");
                                } else if (calytekstPole.getValue().length() <= 48) {

                                    tekstPole4.setValue("");
                                }

                                //horizontal3.removeAllComponents();
                                //horizontal2.removeAllComponents();
                                //horizontal4.removeAllComponents();
                                display();
                                //horizontal4.addComponents(tekstHexPanel, tekstHexPanel2, tekstHexPanel3, tekstHexPanel4);
                                //horizontal3.addComponents(xorPanel, xorPanel2, xorPanel3, xorPanel4);
                                //horizontal2.addComponents(wynikPanel, wynikPanel2, wynikPanel3, wynikPanel4);
                                if (!tekstPole.isEmpty()) {
                                    vertical9.setHeight("200px");
                                    vertical9.addComponent(ivHexPanel);
                                    vertical9.setComponentAlignment(ivHexPanel, Alignment.BOTTOM_RIGHT);

                                    vertical2.addComponents(tekstHexPanel, image5, xorPanel, image, wynikPanel);
                                    vertical2.setComponentAlignment(tekstHexPanel, Alignment.MIDDLE_CENTER);
                                    vertical2.setComponentAlignment(xorPanel, Alignment.MIDDLE_CENTER);
                                    vertical2.setComponentAlignment(wynikPanel, Alignment.MIDDLE_CENTER);
                                    vertical2.setComponentAlignment(image5, Alignment.MIDDLE_CENTER);
                                    vertical2.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
                                } else {
                                    vertical9.removeAllComponents();
                                    vertical2.removeAllComponents();
                                    vertical2.addComponent(tekstPole);
                                }

                                if (!tekstPole2.isEmpty()) {
                                    vertical3.addComponent(image9);
                                    vertical3.setHeight("500px");
                                    vertical3.setComponentAlignment(image9, Alignment.BOTTOM_LEFT);

                                    vertical4.addComponents(tekstHexPanel2, image6, xorPanel2, image2, wynikPanel2);
                                    vertical4.setComponentAlignment(tekstHexPanel2, Alignment.MIDDLE_CENTER);
                                    vertical4.setComponentAlignment(xorPanel2, Alignment.MIDDLE_CENTER);
                                    vertical4.setComponentAlignment(wynikPanel2, Alignment.MIDDLE_CENTER);
                                    vertical4.setComponentAlignment(image6, Alignment.MIDDLE_CENTER);
                                    vertical4.setComponentAlignment(image2, Alignment.MIDDLE_CENTER);
                                } else {
                                    vertical3.removeAllComponents();
                                    vertical4.removeAllComponents();
                                    vertical4.addComponent(tekstPole2);

                                }

                                if (!tekstPole3.isEmpty()) {
                                    vertical5.addComponent(image10);
                                    vertical5.setHeight("500px");
                                    vertical5.setComponentAlignment(image10, Alignment.BOTTOM_LEFT);

                                    vertical6.addComponents(tekstHexPanel3, image7, xorPanel3, image3, wynikPanel3);
                                    vertical6.setComponentAlignment(tekstHexPanel3, Alignment.MIDDLE_CENTER);
                                    vertical6.setComponentAlignment(xorPanel3, Alignment.MIDDLE_CENTER);
                                    vertical6.setComponentAlignment(wynikPanel3, Alignment.MIDDLE_CENTER);
                                    vertical6.setComponentAlignment(image7, Alignment.MIDDLE_CENTER);
                                    vertical6.setComponentAlignment(image3, Alignment.MIDDLE_CENTER);
                                } else {
                                    vertical5.removeAllComponents();
                                    vertical6.removeAllComponents();
                                    vertical6.addComponent(tekstPole3);
                                }
                                if (!tekstPole4.isEmpty()) {
                                    vertical7.addComponent(image11);
                                    vertical7.setHeight("500px");
                                    vertical7.setComponentAlignment(image11, Alignment.BOTTOM_LEFT);

                                    vertical8.addComponents(tekstHexPanel4, image8, xorPanel4, image4, wynikPanel4);
                                    vertical8.setComponentAlignment(tekstHexPanel4, Alignment.MIDDLE_CENTER);
                                    vertical8.setComponentAlignment(xorPanel4, Alignment.MIDDLE_CENTER);
                                    vertical8.setComponentAlignment(wynikPanel4, Alignment.MIDDLE_CENTER);
                                    vertical8.setComponentAlignment(image8, Alignment.MIDDLE_CENTER);
                                    vertical8.setComponentAlignment(image4, Alignment.MIDDLE_CENTER);
                                } else {
                                    vertical7.removeAllComponents();
                                    vertical8.removeAllComponents();
                                    vertical8.addComponent(tekstPole4);
                                }
                            } else ivPole.setValue("Za krótki wektor");
                        } else kluczPole.setValue("Zła długość klucza");

                    }


                });
        //addComponent(b);
        vertical.addComponents(kluczPole, ivPole, calytekstPole, b);
        //vertical.setHeight("190px");
        vertical.setComponentAlignment(kluczPole, Alignment.TOP_LEFT);
        vertical.setComponentAlignment(ivPole, Alignment.TOP_LEFT);
        vertical.setComponentAlignment(b, Alignment.TOP_LEFT);
        vertical2.addComponent(tekstPole);
        vertical4.addComponent(tekstPole2);
        vertical6.addComponent(tekstPole3);
        vertical8.addComponent(tekstPole4);

        addComponents(vertical9, vertical2, vertical3, vertical4, vertical5, vertical6, vertical7, vertical8, vertical);
    }

    private void display() {
        String tekst;
        String xor, xor2, xor3, xor4;

        int i = 0;
        String iv, key;

        tekst = tekstPole.getValue() + tekstPole2.getValue() + tekstPole3.getValue() + tekstPole4.getValue();

        iv = ivPole.getValue();
        key = kluczPole.getValue();

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();

        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        StringBuilder sb8 = new StringBuilder();


        if (!tekstPole.isEmpty()) {
            byte[] wyniktmp = AES_CBC.encrypt(tekst.getBytes(), key.getBytes(), iv.getBytes());
            for (byte b : wyniktmp) {
                i++;
                if (i <= 16) {
                    sb.append(String.format("%02X ", b));
                    wynikPole.setValue(sb.toString());
                } else if (i <= 32 && i > 16) {
                    sb2.append(String.format("%02X ", b));
                    wynikPole2.setValue(sb2.toString());
                } else if (i <= 48 && i > 32) {
                    sb3.append(String.format("%02X ", b));
                    wynikPole3.setValue(sb3.toString());
                } else {
                    sb4.append(String.format("%02X ", b));
                    wynikPole4.setValue(sb4.toString());
                }
            }
            wynikPanel.setWidth("77px");
            wynikPanel.setContent(wynikPole);


            wynikPanel2.setWidth("77px");
            wynikPanel2.setContent(wynikPole2);


            wynikPanel3.setWidth("77px");
            wynikPanel3.setContent(wynikPole3);

            wynikPanel4.setWidth("77px");
            wynikPanel4.setContent(wynikPole4);

            if (!tekstPole.isEmpty()) {
                byte[] xorArray = short_xor_func(iv.getBytes(), tekstPole.getValue().getBytes());
                for (byte b : xorArray) {

                    sb5.append(String.format("%02X ", b));
                    xorPole.setValue(sb5.toString());
                    tekstHexPole.setValue(toHex(tekstPole.getValue()));
                    ivHexPole.setValue(toHex(ivPole.getValue()));
                }

            }
            if (!tekstPole2.isEmpty()) {
                byte[] wynik2byte = new byte[16];
                for (int j = 0; j < 16; j++) {
                    wynik2byte[j] = wyniktmp[j];
                }
                byte[] xorArray = short_xor_func(wynik2byte, tekstPole2.getValue().getBytes());
                for (byte b : xorArray) {

                    sb6.append(String.format("%02X ", b));
                    xorPole2.setValue(sb6.toString());
                    tekstHexPole2.setValue(toHex(tekstPole2.getValue()));
                }
            }
            if (!tekstPole3.isEmpty()) {
                byte[] wynik3byte = new byte[16];
                for (int j = 16; j < 32; j++) {
                    wynik3byte[j - 16] = wyniktmp[j];
                }
                byte[] xor2Array = short_xor_func(wynik3byte, tekstPole3.getValue().getBytes());
                for (byte b : xor2Array) {

                    sb7.append(String.format("%02X ", b));
                    xorPole3.setValue(sb7.toString());
                    tekstHexPole3.setValue(toHex(tekstPole3.getValue()));
                }
            }
            if (!tekstPole4.isEmpty()) {
                byte[] wynik4byte = new byte[16];
                for (int j = 32; j < 48; j++) {
                    wynik4byte[j - 32] = wyniktmp[j];
                }
                byte[] xor3Array = short_xor_func(wynik4byte, tekstPole4.getValue().getBytes());
                for (byte b : xor3Array) {

                    sb8.append(String.format("%02X ", b));
                    xorPole4.setValue(sb8.toString());
                    tekstHexPole4.setValue(toHex(tekstPole4.getValue()));
                }
            }

           /* String xorArrayHelp = iv+wynikPole.getValue()+wynikPole2.getValue()+wynikPole3.getValue();
            byte[] xorArray = short_xor_func(xorArrayHelp.getBytes(),tekst.getBytes());
            for (byte b : xorArray) {
                i++;
                if (i <= 16) {
                    sb5.append(String.format("%02X ", b));
                    xorPole.setValue(sb5.toString());
                } else if (i <= 32 && i > 16) {
                    sb6.append(String.format("%02X ", b));
                    xorPole2.setValue(sb6.toString());
                } else if (i <= 48 && i > 32) {
                    sb7.append(String.format("%02X ", b));
                    xorPole3.setValue(sb7.toString());
                } else if(i>48) {
                    sb8.append(String.format("%02X ", b));
                    xorPole4.setValue(sb8.toString());
                }
            }*/

            xorPanel.setWidth("77px");
            xorPanel.setContent(xorPole);

            xorPanel2.setWidth("77px");
            xorPanel2.setContent(xorPole2);

            xorPanel3.setWidth("77px");
            xorPanel3.setContent(xorPole3);

            xorPanel4.setWidth("77px");
            xorPanel4.setContent(xorPole4);

            tekstHexPanel.setWidth("78px");
            tekstHexPanel.setHeight("78px");
            tekstHexPanel.setContent(tekstHexPole);

            tekstHexPanel2.setWidth("78px");
            tekstHexPanel2.setHeight("78px");
            tekstHexPanel2.setContent(tekstHexPole2);

            tekstHexPanel3.setWidth("78px");
            tekstHexPanel3.setHeight("78px");
            tekstHexPanel3.setContent(tekstHexPole3);

            tekstHexPanel4.setWidth("78px");
            tekstHexPanel4.setHeight("78px");
            tekstHexPanel4.setContent(tekstHexPole4);

            ivHexPanel.setWidth("78px");
            ivHexPanel.setHeight("78px");
            ivHexPanel.setContent(ivHexPole);


        }
    }


    private static byte[] short_xor_func(byte[] a, byte[] b) {
        int length;
        if (a.length > b.length) {
            length = b.length;
        } else length = a.length;
        byte[] out = new byte[a.length];


        for (int i = 0; i < length; i++) {
            out[i] = (byte) (a[i] ^ b[i]);
        }
        for (int i = length; i < a.length; i++) {
            out[i] = a[i];
        }
        return out;

    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    private String toHex(String arg) {

        return spacing(String.format("%02X ", new BigInteger(1, arg.getBytes())));
    }

    private String spacing(String in) {

        int interval = 2;
        char separator = ' ';

        StringBuilder sb = new StringBuilder(in);

        for (int i = 0; i < in.length() / interval; i++) {
            sb.insert(((i + 1) * interval) + i, separator);
        }

        String withDashes = sb.toString();
        return withDashes;
    }

    private int getMin(int num1, int num2) {
        if (num1 <= num2)
            return num1;
        else return num2;
    }
}
