/*
 * Copyright 2020 Takashi Nakamoto.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Majority of this source file was originated from Detector.java in os-maven-plugin.
 * Here is the original version.
 *   https://github.com/trustin/os-maven-plugin/blob/efdef93d6c583824228a84748a75c963d50c5c3c/src/main/java/kr/motd/maven/os/Detector.java
 *
 * To make some private methods available for other packages, some changes were made
 * mainly to remove unnecessarily methods.
 *
 * Below is the copyright notice of the original source file.
 */

/*
 * Copyright 2014 Trustin Heuiseung Lee.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.tnakamot.os;

import java.util.Locale;

public class Detector {
    private static final String UNKNOWN = "unknown";

    /**
     * Returns the normalized OS name of the platform that is currently running
     * based on os.name property.
     *
     * @return normalized OS name
     */
    public static String getNormalizedOSName() {
        return getNormalizedOSName(System.getProperty("os.name"));
    }

    /**
     * Returns the normalized OS name of the given OS name.
     *
     * @param value OS name to normalize. Typically, System.getProperty("os.name") should be passed.
     * @return normalizd OS name
     */
    public static String getNormalizedOSName(String value) {
        value = normalize(value);
        if (value.startsWith("aix")) {
            return "aix";
        }
        if (value.startsWith("hpux")) {
            return "hpux";
        }
        if (value.startsWith("os400")) {
            // Avoid the names such as os4000
            if (value.length() <= 5 || !Character.isDigit(value.charAt(5))) {
                return "os400";
            }
        }
        if (value.startsWith("linux")) {
            return "linux";
        }
        if (value.startsWith("macosx") || value.startsWith("osx")) {
            return "osx";
        }
        if (value.startsWith("freebsd")) {
            return "freebsd";
        }
        if (value.startsWith("openbsd")) {
            return "openbsd";
        }
        if (value.startsWith("netbsd")) {
            return "netbsd";
        }
        if (value.startsWith("solaris") || value.startsWith("sunos")) {
            return "sunos";
        }
        if (value.startsWith("windows")) {
            return "windows";
        }
        if (value.startsWith("zos")) {
            return "zos";
        }

        return UNKNOWN;
    }

    /**
     * Returns the normalized architecture name of the platform that is currently
     * running based on os.arch property.
     *
     * @return normalized architecture name
     */
    public static String getNormalizedArchitectureName() {
        return getNormalizedArchitectureName(System.getProperty("os.arch"));
    }

    /**
     * Returns the normalized architecture name of the given architecture name.
     *
     * @param value architecture name to normalize. Typically, System.getProperty("os.archive") should be passed.
     * @return normalizd architecture name
     */
    public static String getNormalizedArchitectureName(String value) {
        value = normalize(value);
        if (value.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
            return "x86_64";
        }
        if (value.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
            return "x86_32";
        }
        if (value.matches("^(ia64w?|itanium64)$")) {
            return "itanium_64";
        }
        if ("ia64n".equals(value)) {
            return "itanium_32";
        }
        if (value.matches("^(sparc|sparc32)$")) {
            return "sparc_32";
        }
        if (value.matches("^(sparcv9|sparc64)$")) {
            return "sparc_64";
        }
        if (value.matches("^(arm|arm32)$")) {
            return "arm_32";
        }
        if ("aarch64".equals(value)) {
            return "aarch_64";
        }
        if (value.matches("^(mips|mips32)$")) {
            return "mips_32";
        }
        if (value.matches("^(mipsel|mips32el)$")) {
            return "mipsel_32";
        }
        if ("mips64".equals(value)) {
            return "mips_64";
        }
        if ("mips64el".equals(value)) {
            return "mipsel_64";
        }
        if (value.matches("^(ppc|ppc32)$")) {
            return "ppc_32";
        }
        if (value.matches("^(ppcle|ppc32le)$")) {
            return "ppcle_32";
        }
        if ("ppc64".equals(value)) {
            return "ppc_64";
        }
        if ("ppc64le".equals(value)) {
            return "ppcle_64";
        }
        if ("s390".equals(value)) {
            return "s390_32";
        }
        if ("s390x".equals(value)) {
            return "s390_64";
        }

        return UNKNOWN;
    }

    private static String normalize(String value) {
        if (value == null) {
            return "";
        }
        return value.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    /*
    public static void main(String args[]) {
        System.out.println("Normalized OS name          : " + getNormalizedOSName());
        System.out.println("Normalized architecture name: " + getNormalizedArchitectureName());
    }
    */
}
