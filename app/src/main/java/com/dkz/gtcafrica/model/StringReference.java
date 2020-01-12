package com.dkz.gtcafrica.model;

public final class StringReference {

    public static String clean(String ref) {
        ref = ref.replace(".", "");
        ref = ref.replace("@", "");
        ref = ref.replace("#", "");
        ref = ref.replace("$", "");
        ref = ref.replace(" ", "");
        ref = ref.replace("]", "");
        return ref;
    }

    public StudentAccount getAnonymousAccount() {

        return new StudentAccount("Anonyme", "gtc.anknown@gtc.com", "1234");
    }

}
