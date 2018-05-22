package com.ulvhamne;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.jsoup.safety.Whitelist;

/**
 * This is the type com.ulvhamne.HtmlCleanupTest.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2017-12-11
 */

class HtmlCleanupTest {
    public static  void main(String... args) {
        final String derpytext = (new Derpy()).getDerpytext();
        final Document parse = Jsoup.parse(derpytext);
        parse.normalise();
        System.out.println(parse.toString());

        System.out.println("DERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERP");

        final String clean = Jsoup.clean(derpytext, Whitelist.relaxed().addAttributes("span", "style"));
        System.out.println(clean);

        System.out.println("DERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERP");


        final Whitelist wl = Whitelist.relaxed();
        wl.addAttributes("span", "style");
        //wl.addTags("font");
        wl.addAttributes("font", "style", "face", "color");
        final String clean2 = Jsoup.clean(derpytext, "", wl, new Document.OutputSettings().prettyPrint(false));
        System.out.println(clean2);

        System.out.println("DERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERP");

        System.out.println(convertToValidXHTML(derpytext));

        System.out.println("DERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERPDERP");

        System.out.println(convertToValidXHTMLFohRealz(derpytext));

    }

    private static String convertToValidXHTML(final String input) {
        final String start = "<body>";
        final String end = "</body>";
        final org.jsoup.nodes.Document doc = Jsoup.parse(input);
        doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
        doc.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
        doc.outputSettings().charset("UTF-8");
        return start.concat(doc.body().html()).concat(end);
    }

    private static String convertToValidXHTMLFohRealz(final String input) {
        final String start = "<body>";
        final String end = "</body>";
        final String html = Jsoup.clean(input,
                Whitelist.relaxed()
                         .addAttributes("span", "style")
                         .addAttributes("font", "style", "face", "color"));
        return start.concat(html).concat(end);
    }

}

