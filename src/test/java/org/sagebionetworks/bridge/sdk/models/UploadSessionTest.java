package org.sagebionetworks.bridge.sdk.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

public class UploadSessionTest {
    
    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(UploadSession.class).suppress(Warning.NONFINAL_FIELDS).allFieldsShouldBeUsed().verify();
    }
    
}
