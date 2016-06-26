package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.fixtures;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.base.tests.BaseUITest;
import info.novatec.aqe.showcase.livingdoc.selenium.fwk.util.Configuration;
import info.novatec.testit.livingdoc.reflect.BeforeTable;

public class BaseDVDStoreFixture extends BaseUITest {

	@BeforeTable
	public void setup() {
		Configuration.loadSystemProperties("default");
	}

}
