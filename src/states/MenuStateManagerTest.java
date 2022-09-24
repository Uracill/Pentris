package states;

import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;

public class MenuStateManagerTest {
	
	private MenuStateManager menuStateManager;
	private MenuState nullState;
	private MenuState mainState;
	private MenuState pentrisState;
	private MenuState optionsState;
	private MenuState pauseState;
	
	public MenuStateManagerTest() {
		menuStateManager = new MenuStateManager();
		nullState = MenuState.Null;
		mainState = MenuState.Main;
		pentrisState = MenuState.Pentris;
		optionsState = MenuState.Options;
		pauseState = MenuState.Pause;
	}
	
	@Test
	public void test_Constructor() {
		assertSame(mainState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
	}
	
	@Test
	public void test_update() {
		menuStateManager.update(MenuState.Null);
		assertSame(nullState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Main);
		assertSame(mainState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Main);
		assertSame(mainState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Options);
		assertSame(optionsState, menuStateManager.getCurrentState());
		assertSame(mainState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Options);
		assertSame(optionsState, menuStateManager.getCurrentState());
		assertSame(mainState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Null);
		assertSame(nullState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Options);
		assertSame(optionsState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Previous);
		assertSame(nullState, menuStateManager.getCurrentState());
		assertSame(optionsState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Pentris);
		assertSame(pentrisState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Pause);
		assertSame(pauseState, menuStateManager.getCurrentState());
		assertSame(pentrisState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Options);
		assertSame(optionsState, menuStateManager.getCurrentState());
		assertSame(pauseState, menuStateManager.getPreviousState());
		assertSame(pentrisState, menuStateManager.getTempState());
		menuStateManager.update(MenuState.Previous);
		assertSame(pauseState, menuStateManager.getCurrentState());
		assertSame(pentrisState, menuStateManager.getPreviousState());
		assertSame(nullState, menuStateManager.getTempState());
	}
}
