package ladder.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ladder.domain.BranchLine;
import ladder.domain.DataProcess;

public class testDataProcess {
	ArrayList<BranchLine> BranchLineArr;
	BranchLine branchLine;
	List<String> names;

	@Before
	public void setup() {
		BranchLineArr = new ArrayList<>();
		branchLine = new BranchLine();
		branchLine.add(true);
		branchLine.add(false);
		BranchLineArr.add(branchLine);
		names = Arrays.asList("pobipobi", "gram");
	}

	@Test
	public void testCheckFlag() {
		assertEquals(true, DataProcess.checkFlag(names));
	}

	@Test
	public void testCheckNamesLength() {
		assertEquals(false, DataProcess.checkNamesLength(names));
	}

	@Test
	public void testCheckNameLength() {
		assertEquals(1, DataProcess.checkNamesLength(names, 0, 0));
		assertEquals(0, DataProcess.checkNamesLength(names, 1, 0));
	}

	@Test
	public void testCheckBranch() {
		assertEquals("-----", DataProcess.checkBranch(0, 0, BranchLineArr));
		assertEquals("     ", DataProcess.checkBranch(0, 1, BranchLineArr));
	}

	@Test
	public void testGetQuarter() {
		assertEquals(true, DataProcess.getQuarter(5));
		assertEquals(false, DataProcess.getQuarter(3));
	}

}
