package states;

import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;

public class MenuStateManagerTest {
	
	private MenuStateManager menuStateManager;
	private MenuState nullState;
	private MenuState mainState;
	private MenuState optionsState;
	
	public MenuStateManagerTest() {
		menuStateManager = new MenuStateManager();
		nullState = MenuState.Null;
		mainState = MenuState.Main;
		optionsState = MenuState.Options;
	}
	
	@Test
	public void test_Constructor() {
		assertSame(mainState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
	}
	
	@Test
	public void test_update() {
		menuStateManager.update(MenuState.Null);
		assertSame(nullState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		menuStateManager.update(MenuState.Main);
		assertSame(mainState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		menuStateManager.update(MenuState.Main);
		assertSame(mainState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		menuStateManager.update(MenuState.Options);
		assertSame(optionsState, menuStateManager.getCurrentState());
		assertSame(mainState, menuStateManager.getPreviousState());
		menuStateManager.update(MenuState.Options);
		assertSame(optionsState, menuStateManager.getCurrentState());
		assertSame(mainState, menuStateManager.getPreviousState());
		menuStateManager.update(MenuState.Null);
		assertSame(nullState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		menuStateManager.update(MenuState.Options);
		assertSame(optionsState, menuStateManager.getCurrentState());
		assertSame(nullState, menuStateManager.getPreviousState());
		menuStateManager.update(MenuState.Previous);
		assertSame(nullState, menuStateManager.getCurrentState());
		assertSame(optionsState, menuStateManager.getPreviousState());
	}
}
