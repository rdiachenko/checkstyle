///////////////////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code and other text files for adherence to a set of rules.
// Copyright (C) 2001-2024 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
///////////////////////////////////////////////////////////////////////////////////////////////

package com.google.checkstyle.test.chapter4formatting.rule43onestatement;

import com.google.googlejavaformat.java.Formatter;
import org.junit.jupiter.api.Test;

import com.google.checkstyle.test.base.AbstractGoogleModuleTestSupport;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OneStatementPerLineTest extends AbstractGoogleModuleTestSupport {

    private static final String[] MODULE = {
        "OneStatementPerLine",
    };

    @Override
    protected String getPackageLocation() {
        return "com/google/checkstyle/test/chapter4formatting/rule43onestatement";
    }

    @Test
    public void testOneStatement() throws Exception {
        final String filePath = getPath("InputOneStatementPerLine.java");

        verifyWithConfigParser(MODULE, filePath);
    }

    @Test
    public void testOneStatementNonCompilableInput() throws Exception {
        final String filePath = getNonCompilablePath("InputOneStatementPerLine.java");

        verifyWithConfigParser(MODULE, filePath);
    }

    @Test
    public void testNoViolationsAfterApplyingGoogleJavaFormat() throws Exception {
        final String filePath = getPath("InputOneStatementPerLine.java");
        verifyWithConfigParser(MODULE, filePath);

        final String original = Files.readString(Paths.get(filePath));
        final String formatted = new Formatter().formatSource(original);
        Path formattedFile = Files.createTempFile("checkstyle", ".java");
        try {
            Files.write(formattedFile, formatted.replaceAll("violation", "fixed").getBytes());
            verifyWithConfigParser(MODULE, formattedFile.toAbsolutePath().toString());
        } finally {
            Files.deleteIfExists(formattedFile);
        }
    }
}
