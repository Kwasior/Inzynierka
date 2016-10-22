package main.tsd.crypto.algoritm;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;
import java.math.BigInteger;

public class OFB_GUI extends HorizontalLayout implements View {

    private final TextField tekstPole = new TextField();
    private final TextField tekstPole2 = new TextField();
    private final TextField tekstPole3 = new TextField();
    private final TextField tekstPole4 = new TextField();

    private final TextField kluczPole = new TextField();
    private final TextField ivPole = new TextField();

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
    private final Label ivHexPole = new Label();
    private final Panel ivHexPanel = new Panel();
    private final TextArea calytekstPole = new TextArea();


    public String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
    public FileResource resource = new FileResource(new File(basepath + "/WEB-INF/images/xor.png"));
    public FileResource resource2 = new FileResource(new File(basepath + "/WEB-INF/images/Ek2_Ofb.png"));
    public FileResource resource3 = new FileResource(new File(basepath + "/WEB-INF/images/bottomLittle.png"));
    public FileResource resource4 = new FileResource(new File(basepath + "/WEB-INF/images/bottom2.png"));
    public FileResource resource5 = new FileResource(new File(basepath + "/WEB-INF/images/bottom3.png"));
    public FileResource resource6 = new FileResource(new File(basepath + "/WEB-INF/images/Ek2.png"));
    Image image = new Image("", resource);
    Image image2 = new Image("", resource);
    Image image3 = new Image("", resource);
    Image image4 = new Image("", resource);

    Image image5 = new Image("", resource2);
    Image image6 = new Image("", resource2);
    Image image7 = new Image("", resource2);

    Image image8 = new Image("", resource3);
    Image image9 = new Image("", resource4);
    Image image10 = new Image("", resource5);

    Image image11 = new Image("", resource6);

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
    VerticalLayout vertical11 = new VerticalLayout();
    VerticalLayout vertical12 = new VerticalLayout();

    public OFB_GUI() {

        horizontal.setWidth("677px");
        tekstPole.setWidth("120px");
        tekstPole2.setWidth("120px");
        tekstPole3.setWidth("120px");
        tekstPole4.setWidth("120px");
        calytekstPole.setWidth("120px");
        calytekstPole.setWordwrap(true);
        calytekstPole.setMaxLength(64);
        ivPole.setValue("Wektor");
        ivPole.setMaxLength(16);
        kluczPole.setValue("Klucz");
        kluczPole.setMaxLength(16);
        calytekstPole.setValue("Tekst do zaszyfrowania");
        tekstPole.setMaxLength(16);
        tekstPole2.setMaxLength(16);
        tekstPole3.setMaxLength(16);
        tekstPole4.setMaxLength(16);
        vertical3.setWidth("95px");
        vertical5.setWidth("95px");
        vertical7.setWidth("95px");
        vertical.setWidth("190px");
        vertical9.addComponents(kluczPole, ivPole);


        setSpacing(true);
        addStyleName("CBC_VSPACING");


        Button b = new Button("Licz",
                new Button.ClickListener() {
                    @Override

                    public void buttonClick(Button.ClickEvent event) {

                        if (kluczPole.getValue().length() == 16 || kluczPole.getValue().length() == 24 || kluczPole.getValue().length() == 32) {

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
                            display();


                        } else kluczPole.setValue("Zła długość klucza");
                    }
                });

        Button bAES = new Button("AES",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {



                        getUI().getNavigator().removeView("OFB");
                        getUI().getNavigator().addView("OFB", new OFB_GUI());
                        getUI().getNavigator().navigateTo("AES");

                    }
                });

        Button bCBC = new Button("CBC",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {



                        getUI().getNavigator().removeView("OFB");
                        getUI().getNavigator().addView("OFB", new OFB_GUI());
                        getUI().getNavigator().navigateTo("CBC");

                    }
                });

        Button bCFB = new Button("CFB",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {



                        getUI().getNavigator().removeView("OFB");
                        getUI().getNavigator().addView("OFB", new OFB_GUI());
                        getUI().getNavigator().navigateTo("CFB");

                    }
                });

        Button bCTR = new Button("CTR",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {



                        getUI().getNavigator().removeView("OFB");
                        getUI().getNavigator().addView("OFB", new OFB_GUI());
                        getUI().getNavigator().navigateTo("CTR");

                    }
                });

        Button bHMAC = new Button("HMAC",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {



                        getUI().getNavigator().removeView("OFB");
                        getUI().getNavigator().addView("OFB", new OFB_GUI());
                        getUI().getNavigator().navigateTo("HMAC");

                    }
                });
        vertical11.addComponents(vertical9, calytekstPole, b, bAES, bCBC, bCFB, bCTR, bHMAC);
        vertical.setHeight("330px");
        vertical12.addComponents(ekPanel, horizontal3);


        vertical12.setComponentAlignment(horizontal3, Alignment.BOTTOM_RIGHT);
        vertical12.setComponentAlignment(ekPanel, Alignment.BOTTOM_RIGHT);
        vertical.addComponent(vertical12);
        vertical.setComponentAlignment(vertical12, Alignment.BOTTOM_RIGHT);

        vertical2.addComponents(tekstPole);
        vertical4.addComponents(tekstPole2);
        vertical6.addComponents(tekstPole3);
        vertical8.addComponents(tekstPole4);

        horizontal2.addComponents( vertical11, vertical, vertical2, vertical3, vertical4, vertical5, vertical6, vertical7, vertical8);
        horizontal2.setComponentAlignment(vertical3, Alignment.BOTTOM_LEFT);
        horizontal2.setComponentAlignment(vertical5, Alignment.BOTTOM_LEFT);
        horizontal2.setComponentAlignment(vertical7, Alignment.BOTTOM_LEFT);

        vertical10.addComponents(horizontal2, horizontal);
        vertical10.setComponentAlignment(horizontal, Alignment.BOTTOM_LEFT);

        addComponent(vertical10);


    }

    private void display() {
        String tekst, tekst2, tekst3, tekst4;
        String wynik, wynik2, wynik3, wynik4;
        int i = 0;
        String iv, key;
        byte[] ek = new byte[tekstPole.getValue().length() + tekstPole2.getValue().length() + tekstPole3.getValue().length() + tekstPole4.getValue().length()];

        tekst = tekstPole.getValue() + tekstPole2.getValue() + tekstPole3.getValue() + tekstPole4.getValue();
        tekst2 = tekstPole2.getValue();
        tekst3 = tekstPole3.getValue();
        tekst4 = tekstPole4.getValue();
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


        byte[][] iveTmp = AES.encrypt(iv.getBytes(), key.getBytes());
        byte[] ive = new byte[16];

        for (int m = 0; m < 16; m++) {
            ive[m] = iveTmp[4][m + 144];
        }

        byte[] wyniktmp = AES_OFB.encrypt(tekst.getBytes(), key.getBytes(), ive);
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
            wynikPanel.setWidth("78px");
            wynikPanel.setContent(wynikPole);


            wynikPanel2.setWidth("78px");
            wynikPanel2.setContent(wynikPole2);


            wynikPanel3.setWidth("78px");
            wynikPanel3.setContent(wynikPole3);

            wynikPanel4.setWidth("78px");
            wynikPanel4.setContent(wynikPole4);

            if (!tekstPole.isEmpty()) {
                iveTmp = AES.encrypt(ivPole.getValue().getBytes(), key.getBytes());
                ive = new byte[16];

                for (int m = 0; m < 16; m++) {
                    ive[m] = iveTmp[4][m + 144];
                }
                for (byte b : ive)
                    sb5.append(String.format("%02X ", b));
                ekPole.setValue(sb5.toString());
                ivHexPole.setValue(toHex(ivPole.getValue()));
            }
            tekstHexPole.setValue(toHex(tekstPole.getValue()));

            if (!tekstPole2.isEmpty()) {


                byte[][] ek22 = AES.encrypt(ive, key.getBytes());
                for (int m = 0; m < 16; m++) {
                    ive[m] = ek22[4][m + 144];
                }
                for (byte b : ive) {
                    sb6.append(String.format("%02X ", b));
                    ekPole2.setValue(sb6.toString());
                }
                tekstHexPole2.setValue(toHex(tekstPole2.getValue()));

            }
            if (!tekstPole3.isEmpty()) {


                byte[][] ek33 = AES.encrypt(ive, key.getBytes());
                for (int m = 0; m < 16; m++) {
                    ive[m] = ek33[4][m + 144];
                }
                for (byte b : ive) {
                    sb7.append(String.format("%02X ", b));
                    ekPole3.setValue(sb7.toString());
                }
                tekstHexPole3.setValue(toHex(tekstPole3.getValue()));

            }
            if (!tekstPole4.isEmpty()) {


                byte[][] ek44 = AES.encrypt(ive, key.getBytes());
                for (int m = 0; m < 16; m++) {
                    ive[m] = ek44[4][m + 144];
                }
                for (byte b : ive) {
                    sb8.append(String.format("%02X ", b));
                    ekPole4.setValue(sb8.toString());
                }
                tekstHexPole4.setValue(toHex(tekstPole4.getValue()));

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

            ivHexPanel.setWidth("78px");
            ivHexPanel.setHeight("78px");
            ivHexPanel.setContent(ivHexPole);

            vertical2.removeAllComponents();
            vertical3.removeAllComponents();
            vertical4.removeAllComponents();
            vertical5.removeAllComponents();
            vertical6.removeAllComponents();
            vertical7.removeAllComponents();
            vertical8.removeAllComponents();
            vertical2.addComponents(tekstPole);
            vertical4.addComponents(tekstPole2);
            vertical6.addComponents(tekstPole3);
            vertical8.addComponents(tekstPole4);
        }
        if (!tekstPole.isEmpty()) {
            horizontal3.addComponents(ivHexPanel, image11);

            horizontal3.setComponentAlignment(ivHexPanel, Alignment.BOTTOM_RIGHT);
            horizontal3.setComponentAlignment(image11, Alignment.BOTTOM_RIGHT);
            vertical2.addComponents(tekstHexPanel, image, wynikPanel);
            vertical2.setWidth("100%");


            vertical2.setComponentAlignment(tekstHexPanel, Alignment.TOP_CENTER);
            vertical2.setComponentAlignment(wynikPanel, Alignment.TOP_CENTER);
        } else {

            vertical.removeAllComponents();
            vertical2.removeAllComponents();
            horizontal.removeAllComponents();
            vertical2.addComponents(tekstPole);

        }


        if (!tekstPole2.isEmpty()) {
            vertical3.addComponents(ekPanel2, image5);
            vertical3.setSizeUndefined();
            vertical3.setComponentAlignment(ekPanel2, Alignment.TOP_RIGHT);
            vertical3.setWidth("95px");

            vertical4.addComponents(tekstHexPanel2, image2, wynikPanel2);
            vertical4.setWidth("100%");
            vertical4.setComponentAlignment(tekstHexPanel2, Alignment.TOP_CENTER);
            vertical4.setComponentAlignment(wynikPanel2, Alignment.TOP_CENTER);
            horizontal.removeAllComponents();
            horizontal.setWidth("365px");
            horizontal.addComponent(image8);
            horizontal.setComponentAlignment(image8, Alignment.TOP_RIGHT);
        } else horizontal.removeAllComponents();

        if (!tekstPole3.isEmpty()) {
            vertical5.addComponents(ekPanel3, image6);
            vertical5.setSizeUndefined();
            vertical5.setComponentAlignment(ekPanel3, Alignment.TOP_RIGHT);
            vertical3.setWidth("95px");

            vertical6.addComponents(tekstHexPanel3, image3, wynikPanel3);
            vertical6.setWidth("100%");
            vertical6.setComponentAlignment(tekstHexPanel3, Alignment.TOP_CENTER);
            vertical6.setComponentAlignment(wynikPanel3, Alignment.TOP_CENTER);

            horizontal.setWidth("580px");
            horizontal.removeComponent(image8);
            horizontal.addComponent(image9);
            horizontal.setComponentAlignment(image9, Alignment.TOP_RIGHT);
        }
        if (!tekstPole4.isEmpty()) {
            vertical7.addComponents(ekPanel4, image7);
            vertical7.setSizeUndefined();
            vertical7.setComponentAlignment(ekPanel4, Alignment.TOP_RIGHT);
            vertical7.setWidth("95px");

            vertical8.addComponents(tekstHexPanel4, image4, wynikPanel4);
            vertical8.setWidth("100%");
            vertical8.setComponentAlignment(tekstHexPanel4, Alignment.TOP_CENTER);
            vertical8.setComponentAlignment(wynikPanel4, Alignment.TOP_CENTER);
            horizontal.setWidth("805px");
            horizontal.removeComponent(image9);
            horizontal.addComponent(image10);
            horizontal.setComponentAlignment(image10, Alignment.TOP_RIGHT);
        }


    }


    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    private static byte[] xor_func(byte[] a, byte[] b) {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ b[i]);
        }
        return out;

    }

    public String toHex(String arg) {

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
