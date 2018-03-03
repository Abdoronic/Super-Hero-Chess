package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.Test;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class M1PublicTests {

	String medicPath = "model.pieces.heroes.Medic";
	String heroPath = "model.pieces.heroes.Hero";
	String activeHeroPath = "model.pieces.heroes.ActivatablePowerHero";
	String nonActiveHeroPath = "model.pieces.heroes.NonActivatablePowerHero";
	String armoredPath = "model.pieces.heroes.Armored";
	String rangedPath = "model.pieces.heroes.Ranged";
	String speedsterPath = "model.pieces.heroes.Speedster";
	String superPath = "model.pieces.heroes.Super";
	String techPath = "model.pieces.heroes.Tech";
	String sideKickPath = "model.pieces.sidekicks.SideKick";
	String sideKick1Path = "model.pieces.sidekicks.SideKickP1";
	String sideKick2Path = "model.pieces.sidekicks.SideKickP2";
	String piecePath = "model.pieces.Piece";
	String movablePath = "model.pieces.Movable";
	String cellPath = "model.game.Cell";
	String directionPath = "model.game.Direction";
	String gamePath = "model.game.Game";
	String playerPath = "model.game.Player";

	String gaePath = "exceptions.GameActionException";
	String ipuePath = "exceptions.InvalidPowerUseException";
	String ipdePath = "exceptions.InvalidPowerDirectionException";
	String iptePath = "exceptions.InvalidPowerTargetException";
	String pauePath = "exceptions.PowerAlreadyUsedException";
	String imePath = "exceptions.InvalidMovementException";
	String umePath = "exceptions.UnallowedMovementException";
	String ocePath = "exceptions.OccupiedCellException";
	String wtePath = "exceptions.WrongTurnException";

	@Test(timeout = 500)
	public void testClassIsAbstractHero() throws Exception {
		testClassIsAbstract(Class.forName(heroPath));
	}

	@Test(timeout = 1000)
	public void testClassIsAbstractInvalidMovementException() throws Exception {
		testClassIsAbstract(Class.forName(imePath));
	}

	@Test(timeout = 500)
	public void testClassIsAbstractInvalidPowerUseException() throws Exception {
		testClassIsAbstract(Class.forName(ipuePath));
	}

	@Test(timeout = 500)
	public void testClassIsAbstractNonActivatablePowerHero() throws Exception {
		testClassIsAbstract(Class.forName(nonActiveHeroPath));
	}

	@Test(timeout = 500)
	public void testClassIsAbstractSideKick() throws Exception {
		testClassIsAbstract(Class.forName(sideKickPath));
	}

	@Test(timeout = 500)
	public void testClassIsSubclassActivatablePowerHero() throws Exception {
		testClassIsSubclass(Class.forName(activeHeroPath),
				Class.forName(heroPath));
	}

	@Test(timeout = 500)
	public void testClassIsSubclassArmored() throws Exception {
		testClassIsSubclass(Class.forName(armoredPath),
				Class.forName(nonActiveHeroPath));
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassInvalidMovementException() throws Exception {
		testClassIsSubclass(Class.forName(imePath), Class.forName(gaePath));
	}

	@Test(timeout = 500)
	public void testClassIsSubclassInvalidPowerDirectionException()
			throws Exception {
		testClassIsSubclass(Class.forName(ipdePath), Class.forName(ipuePath));
	}

	@Test(timeout = 500)
	public void testClassIsSubclassInvalidPowerTargetException()
			throws Exception {
		testClassIsSubclass(Class.forName(iptePath), Class.forName(ipuePath));
	}

	@Test(timeout = 500)
	public void testClassIsSubclassInvalidPowerUseException() throws Exception {
		testClassIsSubclass(Class.forName(ipuePath), Class.forName(gaePath));
	}

	@Test(timeout = 500)
	public void testClassIsSubclassMedic() throws Exception {
		testClassIsSubclass(Class.forName(medicPath),
				Class.forName(activeHeroPath));
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassPowerAlreadyUsedException() throws Exception {
		testClassIsSubclass(Class.forName(pauePath), Class.forName(ipuePath));
	}

	@Test(timeout = 500)
	public void testClassIsSubclassRanged() throws Exception {
		testClassIsSubclass(Class.forName(rangedPath),
				Class.forName(activeHeroPath));
	}

	@Test(timeout = 500)
	public void testClassIsSubclassSideKick() throws Exception {
		testClassIsSubclass(Class.forName(sideKickPath),
				Class.forName(piecePath));
	}

	@Test(timeout = 500)
	public void testClassIsSubclassSideKickP1() throws Exception {
		testClassIsSubclass(Class.forName(sideKick1Path),
				Class.forName(sideKickPath));
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassUnallowedMovementException()
			throws Exception {
		testClassIsSubclass(Class.forName(umePath), Class.forName(imePath));
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassWrongTurnException() throws Exception {
		testClassIsSubclass(Class.forName(wtePath), Class.forName(gaePath));
	}

	@Test(timeout = 500)
	public void testConstructorCellConstructor1Initialization()
			throws Exception {
		Constructor<?> constructor = Class.forName(cellPath).getConstructor();

		Object myObj = constructor.newInstance();
		String[] names = { "piece" };
		Object[] values = { null };
		testConstructorInitialization(myObj, names, values);

	}

	@Test(timeout = 500)
	public void testConstructorCellConstructor2() throws Exception {
		Class[] inputs = { Class.forName(piecePath) };
		testConstructorExists(Class.forName(cellPath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorGameActionException1() throws Exception {

		Class[] inputs = { Class.forName(piecePath) };
		testConstructorExists(Class.forName(gaePath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorGameConstructor1() throws Exception {
		Class[] inputs = { Class.forName(playerPath), Class.forName(playerPath) };
		testConstructorExists(Class.forName(gamePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorInvalidMovementExceptionConstructor2()
			throws Exception {
		Class[] inputs = { String.class, Class.forName(piecePath),
				Class.forName(directionPath) };
		testConstructorExists(Class.forName(imePath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorInvalidPowerDirectionException1()
			throws Exception {

		Class[] inputs = { Class.forName(piecePath),
				Class.forName(directionPath) };
		testConstructorExists(Class.forName(ipdePath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorInvalidPowerDirectionException2()
			throws Exception {

		Class[] inputs = { String.class, Class.forName(piecePath),
				Class.forName(directionPath) };
		testConstructorExists(Class.forName(ipdePath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorInvalidPowerTargetException1() throws Exception {

		Class[] inputs = { Class.forName(piecePath), Class.forName(piecePath) };
		testConstructorExists(Class.forName(iptePath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorInvalidPowerTargetException2() throws Exception {

		Class[] inputs = { String.class, Class.forName(piecePath),
				Class.forName(piecePath) };
		testConstructorExists(Class.forName(iptePath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorInvalidPowerUseException1() throws Exception {

		Class[] inputs = { Class.forName(piecePath) };
		testConstructorExists(Class.forName(ipuePath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorInvalidPowerUseException2() throws Exception {

		Class[] inputs = { String.class, Class.forName(piecePath) };
		testConstructorExists(Class.forName(ipuePath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorMedicInitialization() throws Exception {

		String testedClassPath = medicPath;

		Class[] inputs = { Class.forName(playerPath), Class.forName(gamePath),
				String.class };
		testConstructorExists(Class.forName(testedClassPath), inputs);

		Constructor<?> constructor = Class.forName(testedClassPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Medic_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object myObj1 = constructor.newInstance(p1, g, n);
		String[] names1 = { "owner", "game", "name" };
		Object[] values1 = { p1, g, n };

		testConstructorInitialization(myObj1, names1, values1);

		Object myObj2 = constructor.newInstance(p2, g, n);
		String[] names2 = { "owner", "game", "name" };
		Object[] values2 = { p2, g, n };

		testConstructorInitialization(myObj2, names2, values2);

	}

	@Test(timeout = 500)
	public void testConstructorNonActivatablePowerHero() throws Exception {

		Class[] inputs = { Class.forName(playerPath), Class.forName(gamePath),
				String.class };
		testConstructorExists(Class.forName(nonActiveHeroPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorOccupiedCellExceptionConstructor1()
			throws Exception {
		Class[] inputs = { Class.forName(piecePath),
				Class.forName(directionPath) };
		testConstructorExists(Class.forName(ocePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorOccupiedCellExceptionConstructor2Initialization()
			throws Exception {
		Constructor<?> constructor = Class.forName(ocePath).getConstructor(
				String.class, Class.forName(piecePath),
				Class.forName(directionPath));

		Object pc1 = createPiece();
		Object d = Enum.valueOf((Class<Enum>) Class.forName(directionPath),
				"DOWN");
		String message = "Error";
		Object myObj = constructor.newInstance(message, pc1, d);
		String[] names = { "trigger", "direction" };
		Object[] values = { pc1, d };
		testConstructorInitialization(myObj, names, values);
		assertEquals("The constructor of the "
				+ myObj.getClass().getSimpleName()
				+ " class should initialize the instance variable \""
				+ "message" + "\" correctly.", message,
				((Exception) myObj).getMessage());
	}

	@Test(timeout = 500)
	public void testConstructorPieceConstructor1() throws Exception {
		Class[] inputs = { Class.forName(playerPath), Class.forName(gamePath),
				String.class };
		testConstructorExists(Class.forName(piecePath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorPlayerConstructorInitialization()
			throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(
				String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);
		String[] names = { "name" };
		Object[] values = { name };
		testConstructorInitialization(myObj, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorPowerAlreadyUsedExceptionConstructor1()
			throws Exception {
		Class[] inputs = { Class.forName(piecePath) };
		testConstructorExists(Class.forName(pauePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorPowerAlreadyUsedExceptionConstructor1Initialization()
			throws Exception {
		Constructor<?> constructor = Class.forName(pauePath).getConstructor(
				Class.forName(piecePath));
		Object pc1 = createPiece();

		Object myObj = constructor.newInstance(pc1);
		String[] names = { "trigger" };
		Object[] values = { pc1 };
		testConstructorInitialization(myObj, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorPowerAlreadyUsedExceptionConstructor2()
			throws Exception {
		Class[] inputs = { String.class, Class.forName(piecePath) };
		testConstructorExists(Class.forName(pauePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorPowerAlreadyUsedExceptionConstructor2Initialization()
			throws Exception {
		Constructor<?> constructor = Class.forName(pauePath).getConstructor(
				String.class, Class.forName(piecePath));
		Object pc1 = createPiece();

		int random = (int) (Math.random() * 40) + 10;
		String message = "Error_" + random;
		Object myObj = constructor.newInstance(message, pc1);
		String[] names = { "trigger" };
		Object[] values = { pc1 };
		testConstructorInitialization(myObj, names, values);

		assertEquals("The constructor of the "
				+ myObj.getClass().getSimpleName()
				+ " class should initialize the instance variable \""
				+ "message" + "\" correctly.", message,
				((Exception) myObj).getMessage());
	}

	@Test(timeout = 500)
	public void testConstructorRanged() throws Exception {

		Class[] inputs = { Class.forName(playerPath), Class.forName(gamePath),
				String.class };
		testConstructorExists(Class.forName(rangedPath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorRangedInitialization() throws Exception {

		String testedClassPath = rangedPath;

		Class[] inputs = { Class.forName(playerPath), Class.forName(gamePath),
				String.class };
		testConstructorExists(Class.forName(testedClassPath), inputs);

		Constructor<?> constructor = Class.forName(testedClassPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Ranged_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object myObj1 = constructor.newInstance(p1, g, n);
		String[] names1 = { "owner", "game", "name" };
		Object[] values1 = { p1, g, n };

		testConstructorInitialization(myObj1, names1, values1);

		Object myObj2 = constructor.newInstance(p2, g, n);
		String[] names2 = { "owner", "game", "name" };
		Object[] values2 = { p2, g, n };

		testConstructorInitialization(myObj2, names2, values2);

	}

	@Test(timeout = 500)
	public void testConstructorSideKickP1Initialization() throws Exception {

		String testedClassPath = sideKick1Path;

		Class[] inputs = { Class.forName(gamePath), String.class };
		testConstructorExists(Class.forName(testedClassPath), inputs);

		Constructor<?> constructor = Class.forName(testedClassPath)
				.getConstructor(Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Tech_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object myObj1 = constructor.newInstance(g, n);
		String[] names1 = { "owner", "game", "name" };
		Object[] values1 = { p1, g, n };

		testConstructorInitialization(myObj1, names1, values1);

		g = gameConstructor.newInstance(p2, p1);

		Object myObj2 = constructor.newInstance(g, n);
		String[] names2 = { "owner", "game", "name" };
		Object[] values2 = { p2, g, n };

		testConstructorInitialization(myObj2, names2, values2);

	}

	@Test(timeout = 500)
	public void testConstructorSideKickP2() throws Exception {
		Class[] inputs = { Class.forName(gamePath), String.class };
		testConstructorExists(Class.forName(sideKick2Path), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorSpeedster() throws Exception {
		Class[] inputs = { Class.forName(playerPath), Class.forName(gamePath),
				String.class };
		testConstructorExists(Class.forName(speedsterPath), inputs);
	}

	@Test(timeout = 500)
	public void testConstructorSuperInitialization() throws Exception {

		String testedClassPath = superPath;

		Class[] inputs = { Class.forName(playerPath), Class.forName(gamePath),
				String.class };
		testConstructorExists(Class.forName(testedClassPath), inputs);

		Constructor<?> constructor = Class.forName(testedClassPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Super_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object myObj1 = constructor.newInstance(p1, g, n);
		String[] names1 = { "owner", "game", "name" };
		Object[] values1 = { p1, g, n };

		testConstructorInitialization(myObj1, names1, values1);

		Object myObj2 = constructor.newInstance(p2, g, n);
		String[] names2 = { "owner", "game", "name" };
		Object[] values2 = { p2, g, n };

		testConstructorInitialization(myObj2, names2, values2);

	}

	@Test(timeout = 500)
	public void testConstructorTech() throws Exception {
		Class[] inputs = { Class.forName(playerPath), Class.forName(gamePath),
				String.class };
		testConstructorExists(Class.forName(techPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorUnallowedMovementExceptionConstructor1Initialization()
			throws Exception {
		Constructor<?> constructor = Class.forName(umePath).getConstructor(
				Class.forName(piecePath), Class.forName(directionPath));

		Object pc1 = createPiece();
		Object d = Enum.valueOf((Class<Enum>) Class.forName(directionPath),
				"DOWN");
		Object myObj = constructor.newInstance(pc1, d);
		String[] names = { "trigger", "direction" };
		Object[] values = { pc1, d };
		testConstructorInitialization(myObj, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorUnallowedMovementExceptionConstructor2()
			throws Exception {
		Class[] inputs = { String.class, Class.forName(piecePath),
				Class.forName(directionPath) };
		testConstructorExists(Class.forName(umePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorUnallowedMovementExceptionConstructor2Initialization()
			throws Exception {
		Constructor<?> constructor = Class.forName(umePath).getConstructor(
				String.class, Class.forName(piecePath),
				Class.forName(directionPath));

		Object pc1 = createPiece();
		Object d = Enum.valueOf((Class<Enum>) Class.forName(directionPath),
				"DOWN");
		String message = "Error";
		Object myObj = constructor.newInstance(message, pc1, d);
		String[] names = { "trigger", "direction" };
		Object[] values = { pc1, d };
		testConstructorInitialization(myObj, names, values);
		assertEquals("The constructor of the "
				+ myObj.getClass().getSimpleName()
				+ " class should initialize the instance variable \""
				+ "message" + "\" correctly.", message,
				((Exception) myObj).getMessage());
	}

	@Test(timeout = 1000)
	public void testConstructorWrongTurnExceptionConstructor1()
			throws Exception {
		Class[] inputs = { Class.forName(piecePath) };
		testConstructorExists(Class.forName(wtePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorWrongTurnExceptionConstructor1Initialization()
			throws Exception {
		Constructor<?> constructor = Class.forName(wtePath).getConstructor(
				Class.forName(piecePath));

		Object pc1 = createPiece();
		Object myObj = constructor.newInstance(pc1);
		String[] names = { "trigger" };
		Object[] values = { pc1 };
		testConstructorInitialization(myObj, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorWrongTurnExceptionConstructor2()
			throws Exception {
		Class[] inputs = { String.class, Class.forName(piecePath) };
		testConstructorExists(Class.forName(wtePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorWrongTurnExceptionConstructor2Initialization()
			throws Exception {
		Constructor<?> constructor = Class.forName(wtePath).getConstructor(
				String.class, Class.forName(piecePath));

		Object pc1 = createPiece();
		String message = "Error";
		Object myObj = constructor.newInstance(message, pc1);
		String[] names = { "trigger" };
		Object[] values = { pc1 };
		testConstructorInitialization(myObj, names, values);
		assertEquals("The constructor of the "
				+ myObj.getClass().getSimpleName()
				+ " class should initialize the instance variable \""
				+ "message" + "\" correctly.", message,
				((Exception) myObj).getMessage());
	}

	@Test(timeout = 500)
	public void testEnumDirection() throws Exception {
		testIsEnum(Class.forName(directionPath));
	}

	@Test(timeout = 500)
	public void testInstanceVariableActiveHeroPowerUsed() throws Exception {
		testInstanceVariableIsPresent(Class.forName(activeHeroPath),
				"powerUsed", true);
		testInstanceVariableIsPrivate(Class.forName(activeHeroPath),
				"powerUsed");
	}

	@Test(timeout = 500)
	public void testInstanceVariableActiveHeroPowerUsedGetter()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(activeHeroPath),
				"isPowerUsed", boolean.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariableActiveHeroPowerUsedGetterLogic()
			throws Exception {

		Method[] methods = Class.forName(medicPath).getDeclaredMethods();

		assertFalse(
				"The isPowerUsed method should not be implemented in subclasses, only inherited from superclass.",
				containsMethodName(methods, "isPowerUsed"));

		Constructor<?> constructor = Class.forName(medicPath).getConstructor(
				Class.forName(playerPath), Class.forName(gamePath),
				String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object myObj = constructor.newInstance(p1, g, n);

		testGetterLogic(myObj, "powerUsed", true);
		testGetterLogic(myObj, "powerUsed", false);

	}

	@Test(timeout = 500)
	public void testInstanceVariableActiveHeroPowerUsedSetter()
			throws Exception {
		testSetterMethodExistsInClass(Class.forName(activeHeroPath),
				"setPowerUsed", boolean.class, true);
	}

	@Test(timeout = 500)
	public void testInstanceVariableArmoredArmorUpGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(armoredPath), "isArmorUp",
				boolean.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariableArmoredArmorUpSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(armoredPath), "setArmorUp",
				boolean.class, true);
	}

	@Test(timeout = 500)
	public void testInstanceVariableCellPieceGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(cellPath), "getPiece",
				Class.forName(piecePath));
	}

	@Test(timeout = 500)
	public void testInstanceVariableCellPieceGetterLogic() throws Exception {
		Constructor<?> constructor = Class.forName(cellPath).getConstructor();

		Object myObj = constructor.newInstance();

		Constructor<?> medicConstructor = Class.forName(medicPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object m = medicConstructor.newInstance(p1, g, n);

		testGetterLogic(myObj, "piece", m);
	}

	@Test(timeout = 500)
	public void testInstanceVariableCellPieceSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(cellPath), "setPiece",
				Class.forName(piecePath), true);
	}

	@Test(timeout = 500)
	public void testInstanceVariableCellPieceSetterLogic() throws Exception {
		Constructor<?> constructor = Class.forName(cellPath).getConstructor();

		Object myObj = constructor.newInstance();
		Constructor<?> medicConstructor = Class.forName(medicPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object m = medicConstructor.newInstance(p1, g, n);

		testSetterLogic(myObj, "piece", m, Class.forName(piecePath));
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameActionExceptionTrigger()
			throws Exception {
		testInstanceVariableIsPresent(Class.forName(gaePath), "trigger", true);
		testInstanceVariableIsPresent(Class.forName(ipuePath), "trigger", false);
		testInstanceVariableIsPresent(Class.forName(iptePath), "trigger", false);
		testInstanceVariableIsPresent(Class.forName(ipdePath), "trigger", false);
		testInstanceVariableIsPrivate(Class.forName(gaePath), "trigger");
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameActionExceptionTriggerSetter()
			throws Exception {
		testSetterMethodExistsInClass(Class.forName(gaePath), "setTrigger",
				Class.forName(piecePath), false);
		testSetterMethodExistsInClass(Class.forName(ipuePath), "setTrigger",
				Class.forName(piecePath), false);
		testSetterMethodExistsInClass(Class.forName(ipdePath), "setTrigger",
				Class.forName(piecePath), false);
		testSetterMethodExistsInClass(Class.forName(iptePath), "setTrigger",
				Class.forName(piecePath), false);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameBoard() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "board", true);
		testInstanceVariableIsPrivate(Class.forName(gamePath), "board");
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameBoardGetter() throws Exception {

		boolean found = true;
		try {
			Class.forName(gamePath).getDeclaredMethod("getBoard");
		} catch (Exception e) {
			found = false;
		}
		assertFalse(
				"The \"board\" variable in Class Game is neither READ nor WRITE variable.",
				found);

	}

	@Test(timeout = 500)
	public void testInstanceVariableGameBoardHeight() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "boardHeight",
				true);
		testInstanceVariableIsPrivate(Class.forName(gamePath), "boardHeight");
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameBoardHeightGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(gamePath),
				"getBoardHeight", int.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameBoardHeightGetterLogic()
			throws Exception {
		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);
		testGetterLogic(g, "boardHeight", 7);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameBoardHeightSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(gamePath),
				"setBoardHeight", int.class, false);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameBoardWidthFinal() throws Exception {
		testInstanceVariableIsFinal(Class.forName(gamePath), "boardWidth");
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameBoardWidthGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getBoardWidth",
				int.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameCurrentPlayerGetterLogic()
			throws Exception {
		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		testGetterLogic(g, "currentPlayer", p1);

		testGetterLogic(g, "currentPlayer", p2);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameCurrentPlayerSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(gamePath),
				"setCurrentPlayer", Class.forName(playerPath), true);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGameCurrentPlayerSetterLogic()
			throws Exception {
		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		testSetterLogic(g, "currentPlayer", p1, Class.forName(playerPath));

		testSetterLogic(g, "currentPlayer", p2, Class.forName(playerPath));
	}

	@Test(timeout = 500)
	public void testInstanceVariableGamePayloadPosTargetFinal()
			throws Exception {
		testInstanceVariableIsFinal(Class.forName(gamePath), "payloadPosTarget");
	}

	@Test(timeout = 500)
	public void testInstanceVariableGamePayloadPosTargetGetterLogic()
			throws Exception {
		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);
		testGetterLogic(g, "payloadPosTarget", 6);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGamePayloadPosTargetSetter()
			throws Exception {
		testSetterMethodExistsInClass(Class.forName(gamePath),
				"setPayloadPosTarget", int.class, false);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGamePlayer1Getter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getPlayer1",
				Class.forName(playerPath));
	}

	@Test(timeout = 500)
	public void testInstanceVariableGamePlayer1GetterLogic() throws Exception {

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		testGetterLogic(g, "player1", p1);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGamePlayer1Setter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setPlayer1",
				Class.forName(playerPath), false);
	}

	@Test(timeout = 500)
	public void testInstanceVariableGamePlayer2() throws Exception {
		testInstanceVariableIsPresent(Class.forName(gamePath), "player2", true);
		testInstanceVariableIsPrivate(Class.forName(gamePath), "player2");
	}

	@Test(timeout = 500)
	public void testInstanceVariableGamePlayer2Getter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(gamePath), "getPlayer2",
				Class.forName(playerPath));
	}

	@Test(timeout = 500)
	public void testInstanceVariableGamePlayer2Setter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(gamePath), "setPlayer2",
				Class.forName(playerPath), false);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableInvalidMovementExceptionDirectionGetter()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(imePath), "getDirection",
				Class.forName(directionPath));
		testGetterMethodDoesNotExistInClass(Class.forName(umePath),
				"getDirection", Object.class);
		testGetterMethodDoesNotExistInClass(Class.forName(ocePath),
				"getDirection", Object.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariableInvalidPowerDirectionExceptionDirection()
			throws Exception {
		testInstanceVariableIsPresent(Class.forName(ipdePath), "direction",
				true);
		testInstanceVariableIsPrivate(Class.forName(ipdePath), "direction");
	}

	@Test(timeout = 500)
	public void testInstanceVariableInvalidPowerDirectionExceptionDirectionGetter()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(ipdePath), "getDirection",
				Class.forName(directionPath));
	}

	@Test(timeout = 500)
	public void testInstanceVariableInvalidPowerDirectionExceptionDirectionSetter()
			throws Exception {
		testSetterMethodExistsInClass(Class.forName(ipdePath), "setDirection",
				Class.forName(directionPath), false);
	}

	@Test(timeout = 500)
	public void testInstanceVariableInvalidPowerTargetExceptionTargetGetterLogic()
			throws Exception {
		Constructor<?> constructor = Class.forName(iptePath).getConstructor(
				String.class, Class.forName(piecePath),
				Class.forName(piecePath));
		Object p = createPiece();
		Object p2 = createPiece();

		Object u = constructor.newInstance("message", p, p2);
		testGetterLogic(u, "target", p2);
	}

	@Test(timeout = 500)
	public void testInstanceVariableInvalidPowerTargetExceptionTargetSetter()
			throws Exception {
		testSetterMethodExistsInClass(Class.forName(iptePath), "setTarget",
				Class.forName(piecePath), false);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePieceGame() throws Exception {
		testInstanceVariableIsPresent(Class.forName(piecePath), "game", true);
		testInstanceVariableIsPrivate(Class.forName(piecePath), "game");

		testInstanceVariableIsPresent(Class.forName(armoredPath), "game", false);
		testInstanceVariableIsPresent(Class.forName(medicPath), "game", false);
		testInstanceVariableIsPresent(Class.forName(speedsterPath), "game",
				false);
		testInstanceVariableIsPresent(Class.forName(rangedPath), "game", false);
		testInstanceVariableIsPresent(Class.forName(techPath), "game", false);
		testInstanceVariableIsPresent(Class.forName(superPath), "game", false);
		testInstanceVariableIsPresent(Class.forName(sideKick1Path), "game",
				false);
		testInstanceVariableIsPresent(Class.forName(sideKick2Path), "game",
				false);

	}

	@Test(timeout = 500)
	public void testInstanceVariablePieceGameGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(piecePath), "getGame",
				Class.forName(gamePath));
		testGetterMethodDoesNotExistInClass(Class.forName(heroPath), "getGame",
				Object.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePieceGameGetterLogic() throws Exception {
		Constructor<?> medicConstructor = Class.forName(medicPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object m = medicConstructor.newInstance(p1, g, n);

		testGetterLogic(m, "game", g);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePieceGameSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(piecePath), "setGame",
				Class.forName(piecePath), false);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePieceNameGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(piecePath), "getName",
				String.class);
		testGetterMethodDoesNotExistInClass(Class.forName(heroPath), "getName",
				Object.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePieceNameGetterLogic() throws Exception {
		Constructor<?> medicConstructor = Class.forName(medicPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object m = medicConstructor.newInstance(p1, g, n);

		testGetterLogic(m, "name", "bla");
	}

	@Test(timeout = 500)
	public void testInstanceVariablePieceNameSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(piecePath), "setName",
				Class.forName(piecePath), false);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePieceOwner() throws Exception {
		testInstanceVariableIsPresent(Class.forName(piecePath), "owner", true);
		testInstanceVariableIsPrivate(Class.forName(piecePath), "owner");

		testInstanceVariableIsPresent(Class.forName(armoredPath), "owner",
				false);
		testInstanceVariableIsPresent(Class.forName(medicPath), "owner", false);
		testInstanceVariableIsPresent(Class.forName(speedsterPath), "owner",
				false);
		testInstanceVariableIsPresent(Class.forName(rangedPath), "owner", false);
		testInstanceVariableIsPresent(Class.forName(techPath), "owner", false);
		testInstanceVariableIsPresent(Class.forName(superPath), "owner", false);
		testInstanceVariableIsPresent(Class.forName(sideKick1Path), "owner",
				false);
		testInstanceVariableIsPresent(Class.forName(sideKick2Path), "owner",
				false);

	}

	@Test(timeout = 500)
	public void testInstanceVariablePieceOwnerGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(piecePath), "getOwner",
				Class.forName(playerPath));
		testGetterMethodDoesNotExistInClass(Class.forName(heroPath),
				"getOwner", Object.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePiecePosI() throws Exception {
		testInstanceVariableIsPresent(Class.forName(piecePath), "posI", true);
		testInstanceVariableIsPrivate(Class.forName(piecePath), "posI");

		testInstanceVariableIsPresent(Class.forName(armoredPath), "posI", false);
		testInstanceVariableIsPresent(Class.forName(medicPath), "posI", false);
		testInstanceVariableIsPresent(Class.forName(speedsterPath), "posI",
				false);
		testInstanceVariableIsPresent(Class.forName(rangedPath), "posI", false);
		testInstanceVariableIsPresent(Class.forName(techPath), "posI", false);
		testInstanceVariableIsPresent(Class.forName(superPath), "posI", false);
		testInstanceVariableIsPresent(Class.forName(sideKick1Path), "posI",
				false);
		testInstanceVariableIsPresent(Class.forName(sideKick2Path), "posI",
				false);

	}

	@Test(timeout = 500)
	public void testInstanceVariablePiecePosIGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(piecePath), "getPosI",
				int.class);
		testGetterMethodDoesNotExistInClass(Class.forName(heroPath), "getPosI",
				Object.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePiecePosIGetterLogic() throws Exception {
		Constructor<?> medicConstructor = Class.forName(medicPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object m = medicConstructor.newInstance(p1, g, n);
		random = (int) (Math.random() * 50);
		testGetterLogic(m, "posI", random);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePiecePosISetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(piecePath), "setPosI",
				int.class, true);
		testSetterMethodExistsInClass(Class.forName(heroPath), "setPosI",
				Object.class, false);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePiecePosISetterLogic() throws Exception {
		Constructor<?> medicConstructor = Class.forName(medicPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object m = medicConstructor.newInstance(p1, g, n);
		random = (int) (Math.random() * 50);

		testSetterLogic(m, "posI", random, int.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePiecePosJGetterLogic() throws Exception {
		Constructor<?> medicConstructor = Class.forName(medicPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object m = medicConstructor.newInstance(p1, g, n);
		random = (int) (Math.random() * 50);
		testGetterLogic(m, "posJ", random);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePiecePosJSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(piecePath), "setPosJ",
				int.class, true);
		testSetterMethodExistsInClass(Class.forName(heroPath), "setPosJ",
				Object.class, false);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePiecePosJSetterLogic() throws Exception {
		Constructor<?> medicConstructor = Class.forName(medicPath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(gamePath), String.class);

		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);

		Object m = medicConstructor.newInstance(p1, g, n);
		random = (int) (Math.random() * 50);

		testSetterLogic(m, "posJ", random, int.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerDeadCharacters() throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath),
				"deadCharacters", true);
		testInstanceVariableIsPrivate(Class.forName(playerPath),
				"deadCharacters");
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerDeadCharactersGetter()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(playerPath),
				"getDeadCharacters", ArrayList.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerDeadCharactersGetterLogic()
			throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(
				String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);
		ArrayList<?> value = new ArrayList<Object>();
		testGetterLogic(myObj, "deadCharacters", value);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerDeadCharactersSetter()
			throws Exception {
		testSetterMethodExistsInClass(Class.forName(playerPath),
				"setDeadCharacters", ArrayList.class, false);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerName() throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath), "name", true);
		testInstanceVariableIsPrivate(Class.forName(playerPath), "name");
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerNameGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(playerPath), "getName",
				String.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerNameGetterLogic() throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(
				String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);
		testGetterLogic(myObj, "name", name);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerPayloadPosGetterLogic()
			throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(
				String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);
		testGetterLogic(myObj, "payloadPos", random);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerPayloadPosSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(playerPath),
				"setPayloadPos", int.class, true);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerSideKilledGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(playerPath),
				"getSideKilled", int.class);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerSideKilledGetterLogic()
			throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(
				String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);
		testGetterLogic(myObj, "sideKilled", random);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerSideKilledSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(playerPath),
				"setSideKilled", int.class, true);
	}

	@Test(timeout = 500)
	public void testInstanceVariablePlayerSideKilledSetterLogic()
			throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(
				String.class);
		int random = (int) (Math.random() * 50);
		String name = "name" + random;
		Object myObj = constructor.newInstance(name);
		testSetterLogic(myObj, "sideKilled", random, int.class);
	}

	@Test(timeout = 500)
	public void testInterfaceMovable() throws Exception {
		testIsInterface(Class.forName(movablePath));
	}

	// ############################################# Helper methods
	// ############################################# //

	private void testInstanceVariableIsPresent(Class aClass, String varName,
			boolean implementedVar) throws SecurityException {

		boolean thrown = false;
		try {
			aClass.getDeclaredField(varName);
		} catch (NoSuchFieldException e) {
			thrown = true;
		}
		if (implementedVar) {
			assertFalse("There should be \"" + varName
					+ "\" instance variable in class " + aClass.getSimpleName()
					+ ".", thrown);
		} else {
			assertTrue(
					"The instance variable \"" + varName
							+ "\" should not be declared in class "
							+ aClass.getSimpleName() + ".", thrown);
		}
	}

	private void testInstanceVariableIsPrivate(Class aClass, String varName)
			throws NoSuchFieldException, SecurityException {
		Field f = aClass.getDeclaredField(varName);
		assertEquals("The \"" + varName + "\" instance variable in class "
				+ aClass.getSimpleName()
				+ " should not be accessed outside that class.", false,
				f.isAccessible());
	}

	private void testInstanceVariableIsFinal(Class aClass, String varName)
			throws NoSuchFieldException, SecurityException {
		Field f = aClass.getDeclaredField(varName);
		assertEquals("The value of \"" + varName
				+ "\" instance variable in class " + aClass.getSimpleName()
				+ " should not be open for changes.", 18, f.getModifiers());

	}

	private void testGetterMethodExistsInClass(Class aClass, String methodName,
			Class returnedType) {
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName);
		} catch (NoSuchMethodException e) {
			found = false;
		}

		String varName = "";
		if (returnedType == boolean.class)
			varName = methodName.substring(2).toLowerCase();
		else
			varName = methodName.substring(3).toLowerCase();

		assertTrue("The \"" + varName + "\" instance variable in class "
				+ aClass.getSimpleName() + " is a READ variable.", found);
		assertTrue("Incorrect return type for " + methodName + " method in "
				+ aClass.getSimpleName() + " class.", m.getReturnType()
				.isAssignableFrom(returnedType));
	}

	private void testSetterMethodExistsInClass(Class aClass, String methodName,
			Class inputType, boolean writeVariable) {

		Method[] methods = aClass.getDeclaredMethods();
		String varName = methodName.substring(3).toLowerCase();
		if (writeVariable) {
			assertTrue("The \"" + varName + "\" instance variable in class "
					+ aClass.getSimpleName() + " is a WRITE variable.",
					containsMethodName(methods, methodName));
		} else {
			assertFalse("The \"" + varName + "\" instance variable in class "
					+ aClass.getSimpleName() + " is not a WRITE variable.",
					containsMethodName(methods, methodName));
			return;
		}
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName, inputType);
		} catch (NoSuchMethodException e) {
			found = false;
		}

		assertTrue(aClass.getSimpleName() + " class should have " + methodName
				+ " method that takes one " + inputType.getSimpleName()
				+ " parameter.", found);

		assertTrue("Incorrect return type for " + methodName + " method in "
				+ aClass.getSimpleName() + ".",
				m.getReturnType().equals(Void.TYPE));

	}

	private static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
		}
		return false;
	}

	private void testConstructorExists(Class aClass, Class[] inputs) {
		boolean thrown = false;
		try {
			aClass.getConstructor(inputs);
		} catch (NoSuchMethodException e) {
			thrown = true;
		}

		if (inputs.length > 0) {
			String msg = "";
			int i = 0;
			do {
				msg += inputs[i].getSimpleName() + " and ";
				i++;
			} while (i < inputs.length);

			msg = msg.substring(0, msg.length() - 4);

			assertFalse(
					"Missing constructor with " + msg + " parameter"
							+ (inputs.length > 1 ? "s" : "") + " in "
							+ aClass.getSimpleName() + " class.",

					thrown);
		} else
			assertFalse(
					"Missing constructor with zero parameters in "
							+ aClass.getSimpleName() + " class.",

					thrown);

	}

	private void testClassIsAbstract(Class aClass) {
		assertTrue("You should not be able to create new instances from "
				+ aClass.getSimpleName() + " class.",
				Modifier.isAbstract(aClass.getModifiers()));
	}

	private void testIsInterface(Class aClass) {
		assertEquals(aClass.getName() + " should be an Interface",
				aClass.isInterface(), true);

	}

	private void testIsEnum(Class aClass) {

		assertEquals(aClass.getName() + " should be an Enum", aClass.isEnum(),
				true);

	}

	private void testConstructorInitialization(Object createdObject,
			String[] names, Object[] values) throws NoSuchMethodException,
			SecurityException, IllegalArgumentException, IllegalAccessException {

		for (int i = 0; i < names.length; i++) {

			Field f = null;
			Class curr = createdObject.getClass();
			String currName = names[i];
			Object currValue = values[i];

			while (f == null) {

				if (curr == Object.class)
					fail("Class " + createdObject.getClass().getSimpleName()
							+ " should have the instance variable \""
							+ currName + "\".");
				try {
					f = curr.getDeclaredField(currName);
				} catch (NoSuchFieldException e) {
					curr = curr.getSuperclass();
				}

			}

			f.setAccessible(true);

			assertEquals("The constructor of the "
					+ createdObject.getClass().getSimpleName()
					+ " class should initialize the instance variable \""
					+ currName + "\" correctly.", currValue,
					f.get(createdObject));

		}

	}

	private void testGetterLogic(Object createdObject, String name, Object value)
			throws Exception {

		Field f = null;
		Class curr = createdObject.getClass();

		while (f == null) {

			if (curr == Object.class)
				fail("Class " + createdObject.getClass().getSimpleName()
						+ " should have the instance variable \"" + name
						+ "\".");
			try {
				f = curr.getDeclaredField(name);
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}

		}

		f.setAccessible(true);
		f.set(createdObject, value);

		Character c = name.charAt(0);

		String methodName = "get" + Character.toUpperCase(c)
				+ name.substring(1, name.length());

		if (value.getClass().equals(Boolean.class))
			methodName = "is" + Character.toUpperCase(c)
					+ name.substring(1, name.length());

		Method m = createdObject.getClass().getMethod(methodName);
		assertEquals("The method \"" + methodName + "\" in class "
				+ createdObject.getClass().getSimpleName()
				+ " should return the correct value of variable \"" + name
				+ "\".", value, m.invoke(createdObject));

	}

	private void testSetterLogic(Object createdObject, String name,
			Object value, Class type) throws Exception {

		Field f = null;
		Class curr = createdObject.getClass();

		while (f == null) {

			if (curr == Object.class)
				fail("Class " + createdObject.getClass().getSimpleName()
						+ " should have the instance variable \"" + name
						+ "\".");
			try {
				f = curr.getDeclaredField(name);
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}

		}

		f.setAccessible(true);

		Character c = name.charAt(0);
		String methodName = "set" + Character.toUpperCase(c)
				+ name.substring(1, name.length());
		Method m = createdObject.getClass().getMethod(methodName, type);
		m.invoke(createdObject, value);

		assertEquals(
				"The method \"" + methodName + "\" in class "
						+ createdObject.getClass().getSimpleName()
						+ " should set the correct value of variable \"" + name
						+ "\".", value, f.get(createdObject));

	}

	private void testClassIsSubclass(Class subClass, Class superClass) {
		assertEquals(
				subClass.getSimpleName() + " class should be a subclass from "
						+ superClass.getSimpleName() + ".", superClass,
				subClass.getSuperclass());
	}

	private Object createPiece() throws NoSuchMethodException,
			SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		String n = "Piece_" + random;

		random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		Constructor<?> constructor = Class.forName(medicPath).getConstructor(
				Class.forName(playerPath), Class.forName(gamePath),
				String.class);
		random = (int) (Math.random() * 40) + 10;
		n = "Piece_" + random;
		Object p = constructor.newInstance(p1, createGame(), n);
		return p;

	}

	private Object createGame() throws NoSuchMethodException,
			SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Constructor<?> gameConstructor = Class.forName(gamePath)
				.getConstructor(Class.forName(playerPath),
						Class.forName(playerPath));

		Constructor<?> playerConstructor = Class.forName(playerPath)
				.getConstructor(String.class);

		int random = (int) (Math.random() * 40) + 10;
		Object p1 = playerConstructor.newInstance("Player_" + random);
		random = (int) (Math.random() * 40) + 10;
		Object p2 = playerConstructor.newInstance("Player_" + random);

		Object g = gameConstructor.newInstance(p1, p2);
		return g;
	}

	private void testGetterMethodDoesNotExistInClass(Class aClass,
			String methodName, Class returnedType) {
		boolean found = true;
		try {
			aClass.getDeclaredMethod(methodName);
		} catch (Exception e) {
			found = false;
		}
		String varName = "";
		if (returnedType == boolean.class)
			varName = methodName.substring(2).toLowerCase();
		else
			varName = methodName.substring(3).toLowerCase();

		assertFalse(
				"The "
						+ aClass.getSimpleName()
						+ " should not contain an instance variable \""
						+ varName
						+ "\" therefore, it should not have a Getter for this variable.",
				found);

	}

}
