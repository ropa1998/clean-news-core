package implementations.scrappers;

import implementations.core.medium.IMedium;

public class Utils {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String cleanExtraSpacesInString(String string) {
        return string.trim().replaceAll(" +", " ");
    }

    public static String cleanCamelCasing(String camelCasedString, String replace) {
        StringBuilder result = new StringBuilder();
        for (String w : camelCasedString.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
            result.append(w).append(replace);
        }
        return cleanExtraSpacesInString(result.toString().trim());
    }

    public static String cleanURL(final String rawURL, final IMedium medium) {
        StringBuilder urlBuilder = new StringBuilder();
        String finalURL;
        if (!rawURL.contains(medium.getScrapperStartingUrl())) {
            urlBuilder.append(medium.getScrapperStartingUrl()).append(rawURL);
            finalURL = urlBuilder.toString();
        } else {
            finalURL = rawURL;
        }

        return finalURL.replaceAll("#[a-zA-Z]+$", ""); //Clean index.html#comments
    }

//    public static boolean listIsEmpty(List<IArticle> articlesForTrend) {
//
//        if (articlesForTrend == null || articlesForTrend.size() == 0) {
//            return true;
//        }
//
//        for (IArticle article : articlesForTrend) {
//            if (article == null) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public static List<IArticle> justThoseWhoContainTheFullWord(List<IArticle> articles, String search) {
//        if (articles.isEmpty()) {
//            return articles;
//        }
//        String regex = "\\b" + search + "\\b";
//        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//        List<IArticle> newArticles = new ArrayList<>();
//        for (IArticle article : articles) {
//            Matcher matcher = pattern.matcher(article.getTitle());
//            if (matcher.find()) {
//                newArticles.add(article);
//            }
//        }
//        return newArticles;
//    }
//
//    public static String cleanBBCBloat(String body) {
//        return body.replace("These are external links and will open in a new window", "");
//    }
//
//    public static String createLink() {
//        int length = 15;
//        StringBuilder builder = new StringBuilder();
//        while (length-- != 0) {
//            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
//            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
//        }
//        return builder.toString();
//    }


}
