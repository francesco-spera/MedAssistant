package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCollegamentoManager.class, TestProfiloManager.class,
		TestRefertoManager.class, TestRicercaManager.class, TestRicettaManager.class, TestVotazioneManager.class })

public class AllTests {

}
