package main.tsd.crypto.algoritm;

import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;
import java.math.BigInteger;

import org.apache.commons.lang3.math.NumberUtils;

public class CTR_GUI extends HorizontalLayout implements View {

    private final TextField tekstPole = new TextField();
    private final TextField tekstPole2 = new TextField();
    private final TextField tekstPole3 = new TextField();
    private final TextField tekstPole4 = new TextField();

    TextArea calytekstPole = new TextArea("Tekst do zaszyfrowania");

    private final TextField kluczPole = new TextField("Klucz");
    private final TextField ivPole = new TextField("Licznik");

    private final Label wynikPole = new Label();
    private final Label wynikPole2 = new Label();
    private final Label wynikPole3 = new Label();
    private final Label wynikPole4 = new Label();

    private final Panel wynikPanel = new Panel();
    private final Panel wynikPanel2 = new Panel();
    private final Panel wynikPanel3 = new Panel();
    private final Panel wynikPanel4 = new Panel();

    private final Label ekPole = new Label();
    private final Label ekPole2 = new Label();
    private final Label ekPole3 = new Label();
    private final Label ekPole4 = new Label();

    private final Panel ekPanel = new Panel();
    private final Panel ekPanel2 = new Panel();
    private final Panel ekPanel3 = new Panel();
    private final Panel ekPanel4 = new Panel();

    private final Label tekstHexPole = new Label();
    private final Label tekstHexPole2 = new Label();
    private final Label tekstHexPole3 = new Label();
    private final Label tekstHexPole4 = new Label();

    private final Panel tekstHexPanel = new Panel();
    private final Panel tekstHexPanel2 = new Panel();
    private final Panel tekstHexPanel3 = new Panel();
    private final Panel tekstHexPanel4 = new Panel();

    Label counter = new Label();
    Label counter2 = new Label();
    Label counter3 = new Label();
    Label counter4 = new Label();

    private final Panel counterPanel = new Panel();
    private final Panel counterPanel2 = new Panel();
    private final Panel counterPanel3 = new Panel();

    public String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
    public FileResource resource = new FileResource(new File(basepath + "/WEB-INF/images/xor.png"));
    public FileResource resource2 = new FileResource(new File(basepath + "/WEB-INF/images/Ek2_Ofb.png"));
    public FileResource resource3 = new FileResource(new File(basepath + "/WEB-INF/images/arrow3.png"));
    public FileResource resource4 = new FileResource(new File(basepath + "/WEB-INF/images/EkCFB.png"));

    Image image = new Image("", resource);
    Image image2 = new Image("", resource);
    Image image3 = new Image("", resource);
    Image image4 = new Image("", resource);

    Image image5 = new Image("", resource2);
    Image image6 = new Image("", resource2);
    Image image7 = new Image("", resource2);

    Image image8 = new Image("", resource3);
    Image image9 = new Image("", resource3);
    Image image10 = new Image("", resource3);

    Image image11 = new Image("", resource4);

    HorizontalLayout horizontal = new HorizontalLayout();

    HorizontalLayout horizontal2 = new HorizontalLayout();
    HorizontalLayout horizontal3 = new HorizontalLayout();
    HorizontalLayout horizontal4 = new HorizontalLayout();
    HorizontalLayout horizontal5 = new HorizontalLayout();
    HorizontalLayout horizontal6 = new HorizontalLayout();
    HorizontalLayout horizontal7 = new HorizontalLayout();
    HorizontalLayout horizontal8 = new HorizontalLayout();


    VerticalLayout vertical = new VerticalLayout();
    VerticalLayout vertical2 = new VerticalLayout();
    VerticalLayout vertical3 = new VerticalLayout();
    VerticalLayout vertical4 = new VerticalLayout();
    VerticalLayout vertical5 = new VerticalLayout();
    VerticalLayout vertical6 = new VerticalLayout();
    VerticalLayout vertical7 = new VerticalLayout();
    VerticalLayout vertical8 = new VerticalLayout();
    VerticalLayout vertical9 = new VerticalLayout();
    VerticalLayout vertical10 = new VerticalLayout();


    public CTR_GUI() {


        //horizontal.setWidth("677px");
        tekstPole.setWidth("120px");
        tekstPole2.setWidth("120px");
        tekstPole3.setWidth("120px");
        tekstPole4.setWidth("120px");



        vertical3.setWidth("78px");
        vertical5.setWidth("78px");
        vertical7.setWidth("78px");

        calytekstPole.setWidth("120px");
        calytekstPole.setWordwrap(true);
        calytekstPole.setMaxLength(64);


        setSpacing(true);
        addStyleName("CBC_VSPACING");


        Button b = new Button("Licz",
                new Button.ClickListener() {
                    @Override

                    public void buttonClick(Button.ClickEvent event) {
                        tekstPole.clear();
                        tekstPole2.clear();
                        tekstPole3.clear();
                        tekstPole4.clear();
                        if (kluczPole.getValue().length() == 16) {
                            if (NumberUtils.isNumber(ivPole.getValue().toString())) {

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
                            } else ivPole.setValue("Nieodpowiedni licznik");
                        } else kluczPole.setValue("Zła dlugość klucza");

                        display();

                    }


                });

        vertical9.addComponents(kluczPole, ivPole, calytekstPole, b);



        vertical2.addComponents(tekstPole);
        vertical4.addComponents(tekstPole2);
        vertical6.addComponents(tekstPole3);
        vertical8.addComponents(tekstPole4);

        horizontal2.addComponents(vertical, vertical2, vertical3, vertical4, vertical5, vertical6, vertical7, vertical8, vertical9);
        horizontal2.setComponentAlignment(vertical3, Alignment.BOTTOM_LEFT);
        horizontal2.setComponentAlignment(vertical5, Alignment.BOTTOM_LEFT);
        horizontal2.setComponentAlignment(vertical7, Alignment.BOTTOM_LEFT);


        vertical10.addComponents(horizontal2, horizontal8);


        addComponent(vertical10);

    }

    private void display() {


        String tekst, tekst2, tekst3, tekst4;
        String wynik, wynik2, wynik3, wynik4;
        int i = 0;
        String iv, key;
        byte[] ek = new byte[tekstPole.getValue().length() + tekstPole2.getValue().length() + tekstPole3.getValue().length() + tekstPole4.getValue().length()];

        tekst = tekstPole.getValue() + tekstPole2.getValue() + tekstPole3.getValue() + tekstPole4.getValue();
        iv = ivPole.getValue();
        key = kluczPole.getValue();
        int j = 0;
        j = Integer.parseInt(iv);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();

        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        StringBuilder sb8 = new StringBuilder();

        byte[][] iveTmp = AES.encrypt(iv.getBytes(), key.getBytes());
        byte[] ive = new byte[16];

        for (int m = 0; m < 16; m++) {
            ive[m] = iveTmp[4][m + 144];
        }
        byte[] wyniktmp = AES_CTR.encrypt(tekst.getBytes(), key.getBytes(), j);
        if (!tekstPole.isEmpty()) {

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
            counter4.setValue(String.valueOf(j));
            counter4.addStyleName("Wyniki");

            wynikPanel.setWidth("78px");
            wynikPanel.setContent(wynikPole);


            wynikPanel2.setWidth("78px");
            wynikPanel2.setContent(wynikPole2);


            wynikPanel3.setWidth("78px");
            wynikPanel3.setContent(wynikPole3);

            wynikPanel4.setWidth("78px");
            wynikPanel4.setContent(wynikPole4);

            if (!tekstPole.isEmpty()) {
                for (byte b : ive)
                    sb5.append(String.format("%02X ", b));
                ekPole.setValue(sb5.toString());
            }
            tekstHexPole.setValue(toHex(tekstPole.getValue()));
        }

            if (!tekstPole2.isEmpty()) {


                byte[][] ek22 = AES.encrypt(String.valueOf(j + 1).getBytes(), key.getBytes());
                for (int m = 0; m < 16; m++) {
                    ive[m] = ek22[4][m + 144];
                }
                for (byte b : ive) {
                    sb6.append(String.format("%02X ", b));
                    ekPole2.setValue(sb6.toString());
                }
                tekstHexPole2.setValue(toHex(tekstPole2.getValue()));
                counter.setValue(String.valueOf(j + 1));
                counter.addStyleName("Wyniki");
                /*horizontal.setWidth("335px");
                horizontal.addComponent(image8);
                horizontal.setComponentAlignment(image8,Alignment.TOP_RIGHT);*/
                horizontal.addComponents(counter, image8);
                horizontal.setComponentAlignment(counter, Alignment.MIDDLE_RIGHT);
                horizontal.setComponentAlignment(image8, Alignment.MIDDLE_CENTER);
                //horizontal.setComponentAlignment(counter, Alignment.MIDDLE_CENTER);
                horizontal5.addComponent(horizontal);
                horizontal5.setWidth("270px");
                horizontal5.setComponentAlignment(horizontal, Alignment.MIDDLE_RIGHT);


                //horizontal.setComponentAlignment(counterPanel,Alignment.BOTTOM_RIGHT);
                //horizontal.setComponentAlignment(image8,Alignment.BOTTOM_LEFT);

            } else {
                horizontal.removeAllComponents();
            }
            if (!tekstPole3.isEmpty()) {


                byte[][] ek33 = AES.encrypt(String.valueOf(j + 2).getBytes(), key.getBytes());
                for (int m = 0; m < 16; m++) {
                    ive[m] = ek33[4][m + 144];
                }
                for (byte b : ive) {
                    sb7.append(String.format("%02X ", b));
                    ekPole3.setValue(sb7.toString());
                }
                tekstHexPole3.setValue(toHex(tekstPole3.getValue()));
                counter2.setValue(String.valueOf(j + 2));
                counter2.addStyleName("Wyniki");
               /* horizontal.setWidth("560px");
                horizontal.removeComponent(image8);
                horizontal.addComponent(image9);
                horizontal.setComponentAlignment(image9,Alignment.TOP_RIGHT);*/
                horizontal3.addComponent(counter2);
                horizontal3.setComponentAlignment(counter2, Alignment.MIDDLE_RIGHT);
                horizontal3.addComponent(image9);
                horizontal3.setComponentAlignment(image9, Alignment.MIDDLE_CENTER);
                horizontal6.addComponent(horizontal3);
                horizontal6.setWidth("200px");
                horizontal6.setComponentAlignment(horizontal3, Alignment.MIDDLE_RIGHT);

            } else {
                horizontal3.removeAllComponents();
            }
            if (!tekstPole4.isEmpty()) {


                byte[][] ek44 = AES.encrypt(String.valueOf(j + 3).getBytes(), key.getBytes());
                for (int m = 0; m < 16; m++) {
                    ive[m] = ek44[4][m + 144];
                }
                for (byte b : ive) {
                    sb8.append(String.format("%02X ", b));
                    counter3.setValue(String.valueOf(j + 3));
                    counter3.addStyleName("Wyniki");
                    ekPole4.setValue(sb8.toString());
                    tekstHexPole4.setValue(toHex(tekstPole4.getValue()));
                    horizontal4.addComponent(counter3);
                    horizontal4.setComponentAlignment(counter3, Alignment.MIDDLE_RIGHT);
                    horizontal4.addComponent(image10);
                    horizontal7.addComponent(horizontal4);
                    horizontal7.setWidth("200px");
                    horizontal7.setComponentAlignment(horizontal4, Alignment.MIDDLE_RIGHT);

                }
            } else {
                horizontal4.removeAllComponents();
            }


            ekPanel.setWidth("78px");
            ekPanel.setHeight("78px");
            ekPanel.setContent(ekPole);

            tekstHexPanel.setWidth("78px");
            tekstHexPanel.setHeight("78px");
            tekstHexPanel.setContent(tekstHexPole);


            ekPanel2.setWidth("78px");
            ekPanel2.setHeight("78px");
            ekPanel2.setContent(ekPole2);

            tekstHexPanel2.setWidth("78px");
            tekstHexPanel2.setHeight("78px");
            tekstHexPanel2.setContent(tekstHexPole2);


            ekPanel3.setWidth("78px");
            ekPanel3.setHeight("78px");
            ekPanel3.setContent(ekPole3);


            tekstHexPanel3.setWidth("78px");
            tekstHexPanel3.setHeight("78px");
            tekstHexPanel3.setContent(tekstHexPole3);


            ekPanel4.setWidth("78px");
            ekPanel.setHeight("78px");
            ekPanel4.setContent(ekPole4);

            tekstHexPanel4.setWidth("78px");
            tekstHexPanel4.setHeight("78px");
            tekstHexPanel4.setContent(tekstHexPole4);


            horizontal8.addComponents(horizontal5, horizontal6, horizontal7);
            horizontal8.setSizeUndefined();
            horizontal8.setComponentAlignment(horizontal5, Alignment.MIDDLE_RIGHT);
            horizontal8.setComponentAlignment(horizontal6, Alignment.MIDDLE_RIGHT);
            horizontal8.setComponentAlignment(horizontal7, Alignment.MIDDLE_RIGHT);


            if (!tekstPole.isEmpty()) {

                vertical.addComponents(counter4, image11, ekPanel);

                vertical.setComponentAlignment(counter4, Alignment.BOTTOM_CENTER);
                vertical.setComponentAlignment(image11, Alignment.TOP_RIGHT);
                vertical.setComponentAlignment(ekPanel, Alignment.BOTTOM_RIGHT);


                vertical2.addComponents(tekstHexPanel, image, wynikPanel);
                vertical2.setWidth("100%");


                vertical2.setComponentAlignment(tekstHexPanel, Alignment.TOP_CENTER);
                vertical2.setComponentAlignment(wynikPanel, Alignment.TOP_CENTER);

            } else {
                vertical.removeAllComponents();
                vertical2.removeAllComponents();
                vertical2.addComponent(tekstPole);
            }
            if (!tekstPole2.isEmpty()) {
                vertical3.addComponents(ekPanel2, image5);
                vertical3.setComponentAlignment(image5, Alignment.TOP_CENTER);
                vertical3.setComponentAlignment(ekPanel2, Alignment.TOP_RIGHT);


                vertical4.addComponents(tekstHexPanel2, image2, wynikPanel2);
                vertical4.setWidth("100%");
                vertical4.setComponentAlignment(tekstHexPanel2, Alignment.TOP_CENTER);
                vertical4.setComponentAlignment(wynikPanel2, Alignment.TOP_CENTER);
            } else {
                vertical3.removeAllComponents();
                vertical4.removeAllComponents();
                vertical4.addComponent(tekstPole2);
            }
            if (!tekstPole3.isEmpty()) {
                vertical5.addComponents(ekPanel3, image6);
                vertical5.setWidth("78px");
                vertical5.setComponentAlignment(ekPanel3, Alignment.TOP_RIGHT);


                vertical6.addComponents(tekstHexPanel3, image3, wynikPanel3);
                vertical6.setWidth("100%");
                vertical6.setComponentAlignment(tekstHexPanel3, Alignment.TOP_CENTER);
                vertical6.setComponentAlignment(wynikPanel3, Alignment.TOP_CENTER);
            } else {
                vertical5.removeAllComponents();
                vertical6.removeAllComponents();
                vertical6.addComponent(tekstPole3);
            }
            if (!tekstPole4.isEmpty()) {
                vertical7.addComponents(ekPanel4, image7);
                vertical7.setWidth("78px");
                vertical7.setComponentAlignment(ekPanel4, Alignment.TOP_RIGHT);


                vertical8.addComponents(tekstHexPanel4, image4, wynikPanel4);
                vertical8.setWidth("100%");
                vertical8.setComponentAlignment(tekstHexPanel4, Alignment.TOP_CENTER);
                vertical8.setComponentAlignment(wynikPanel4, Alignment.TOP_CENTER);
            } else {
                vertical7.removeAllComponents();
                vertical8.removeAllComponents();
                vertical8.addComponent(tekstPole4);
            }


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

    private static byte[] xor_func(byte[] a, byte[] b) {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ b[i]);
        }
        return out;

    }

    private int getMin(int num1, int num2) {
        if (num1 <= num2)
            return num1;
        else return num2;
    }
}
