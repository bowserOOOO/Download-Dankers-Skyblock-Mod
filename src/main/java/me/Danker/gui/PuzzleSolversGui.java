package me.Danker.gui;

import me.Danker.commands.ToggleCommand;
import me.Danker.handlers.ConfigHandler;
import me.Danker.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class PuzzleSolversGui extends GuiScreen {

	private int page;
	
	private GuiButton goBack;
	private GuiButton backPage;
	private GuiButton nextPage;
	private GuiButton riddle;
	private GuiButton trivia;
	private GuiButton blaze;
	private GuiButton creeper;
	private GuiButton creeperLines;
	private GuiButton water;
	private GuiButton ticTacToe;
	private GuiButton boulder;
	private GuiButton silverfish;
	private GuiButton iceWalk;
	private GuiButton startsWith;
	private GuiButton selectAll;
	private GuiButton clickOrder;
	private GuiButton sameColour;
	private GuiButton blockClicks;
	private GuiButton itemFrameOnSeaLanterns;
	
	public PuzzleSolversGui(int page) {
		this.page = page;
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		int height = sr.getScaledHeight();
		int width = sr.getScaledWidth();
		
		goBack = new GuiButton(0, 2, height - 30, 100, 20, "Go Back");
		backPage = new GuiButton(0, width / 2 - 100, (int) (height * 0.8), 80, 20, "< Back");
		nextPage = new GuiButton(0, width / 2 + 20, (int) (height * 0.8), 80, 20, "Next >");
		
		// Page 1
		riddle = new GuiButton(0, width / 2 - 100, (int) (height * 0.1), "Riddle Solver: " + Utils.getColouredBoolean(ToggleCommand.threeManToggled));
		trivia = new GuiButton(0, width / 2 - 100, (int) (height * 0.2), "Trivia Solver: " + Utils.getColouredBoolean(ToggleCommand.oruoToggled));
		blaze = new GuiButton(0, width / 2 - 100, (int) (height * 0.3), "Blaze Solver: " + Utils.getColouredBoolean(ToggleCommand.blazeToggled));
		creeper = new GuiButton(0, width / 2 - 100, (int) (height * 0.4), "Creeper Solver: " + Utils.getColouredBoolean(ToggleCommand.creeperToggled));
		creeperLines = new GuiButton(0, width / 2 - 100, (int) (height * 0.5), "Lines In Creeper Solver: " + Utils.getColouredBoolean(ToggleCommand.creeperLinesToggled));
		water = new GuiButton(0, width / 2 - 100, (int) (height * 0.6), "Water Solver: " + Utils.getColouredBoolean(ToggleCommand.waterToggled));
		ticTacToe = new GuiButton(0, width / 2 - 100, (int) (height * 0.7), "Tic Tac Toe Solver: " + Utils.getColouredBoolean(ToggleCommand.ticTacToeToggled));
		// Page 2
		boulder = new GuiButton(0, width / 2 - 100, (int) (height * 0.1), "Boulder Solver: " + Utils.getColouredBoolean(ToggleCommand.boulderToggled));
		silverfish = new GuiButton(0, width / 2 - 100, (int) (height * 0.2), "Silverfish Solver: " + Utils.getColouredBoolean(ToggleCommand.silverfishToggled));
		iceWalk = new GuiButton(0, width / 2 - 100, (int) (height * 0.3), "Ice Walk Solver: " + Utils.getColouredBoolean(ToggleCommand.iceWalkToggled));
		startsWith = new GuiButton(0, width / 2 - 100, (int) (height * 0.4), "Starts With Letter Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.startsWithToggled));
		selectAll = new GuiButton(0, width / 2 - 100, (int) (height * 0.5), "Select All Color Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.selectAllToggled));
		clickOrder = new GuiButton(0, width / 2 - 100, (int) (height * 0.6), "Click in Order Terminal Helper: " + Utils.getColouredBoolean(ToggleCommand.clickInOrderToggled));
		sameColour = new GuiButton(0, width / 2 - 100, (int) (height * 0.7), "Same Colour Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.sameColourToggled));
		// Page 3
		blockClicks = new GuiButton(0, width / 2 - 100, (int) (height * 0.1), "Block Wrong Clicks on Terminals: " + Utils.getColouredBoolean(ToggleCommand.blockWrongTerminalClicksToggled));
		itemFrameOnSeaLanterns = new GuiButton(0, width / 2 - 100, (int) (height * 0.2), "Ignore Arrows On Sea Lanterns: " + Utils.getColouredBoolean(ToggleCommand.itemFrameOnSeaLanternsToggled));

		switch (page) {
			case 1:
				this.buttonList.add(riddle);
				this.buttonList.add(trivia);
				this.buttonList.add(blaze);
				this.buttonList.add(creeper);
				this.buttonList.add(creeperLines);
				this.buttonList.add(water);
				this.buttonList.add(ticTacToe);
				this.buttonList.add(nextPage);
				break;
			case 2:
				this.buttonList.add(boulder);
				this.buttonList.add(silverfish);
				this.buttonList.add(iceWalk);
				this.buttonList.add(startsWith);
				this.buttonList.add(selectAll);
				this.buttonList.add(clickOrder);
				this.buttonList.add(sameColour);
				this.buttonList.add(nextPage);
				this.buttonList.add(backPage);
				break;
			case 3:
				this.buttonList.add(blockClicks);
				this.buttonList.add(itemFrameOnSeaLanterns);
				this.buttonList.add(backPage);
		}
		this.buttonList.add(goBack);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		if (button == goBack) {
			mc.displayGuiScreen(new DankerGui(1, ""));
		} else if (button == backPage) {
			Minecraft.getMinecraft().displayGuiScreen(new PuzzleSolversGui(page - 1));
		} else if (button == nextPage) {
			Minecraft.getMinecraft().displayGuiScreen(new PuzzleSolversGui(page + 1));
		} else if (button == riddle) {
			ToggleCommand.threeManToggled = !ToggleCommand.threeManToggled;
			ConfigHandler.writeBooleanConfig("toggles", "ThreeManPuzzle", ToggleCommand.threeManToggled);
			riddle.displayString = "Riddle Solver: " + Utils.getColouredBoolean(ToggleCommand.threeManToggled);
		} else if (button == trivia) {
			ToggleCommand.oruoToggled = !ToggleCommand.oruoToggled;
			ConfigHandler.writeBooleanConfig("toggles", "OruoPuzzle", ToggleCommand.oruoToggled);
			trivia.displayString = "Trivia Solver: " + Utils.getColouredBoolean(ToggleCommand.oruoToggled);
		} else if (button == blaze) {
			ToggleCommand.blazeToggled = !ToggleCommand.blazeToggled;
			ConfigHandler.writeBooleanConfig("toggles", "BlazePuzzle", ToggleCommand.blazeToggled);
			blaze.displayString = "Blaze Solver: " + Utils.getColouredBoolean(ToggleCommand.blazeToggled);
		} else if (button == creeper) {
			ToggleCommand.creeperToggled = !ToggleCommand.creeperToggled;
			ConfigHandler.writeBooleanConfig("toggles", "CreeperPuzzle", ToggleCommand.creeperToggled);
			creeper.displayString = "Creeper Solver: " + Utils.getColouredBoolean(ToggleCommand.creeperToggled);
		} else if (button == creeperLines) {
			ToggleCommand.creeperLinesToggled = !ToggleCommand.creeperLinesToggled;
			ConfigHandler.writeBooleanConfig("toggles", "CreeperLines", ToggleCommand.creeperLinesToggled);
			creeperLines.displayString = "Lines In Creeper Solver: " + Utils.getColouredBoolean(ToggleCommand.creeperLinesToggled);
		} else if (button == water) {
			ToggleCommand.waterToggled = !ToggleCommand.waterToggled;
			ConfigHandler.writeBooleanConfig("toggles", "WaterPuzzle", ToggleCommand.waterToggled);
			water.displayString = "Water Solver: " + Utils.getColouredBoolean(ToggleCommand.waterToggled);
		} else if (button == ticTacToe) {
			ToggleCommand.ticTacToeToggled = !ToggleCommand.ticTacToeToggled;
			ConfigHandler.writeBooleanConfig("toggles", "TicTacToePuzzle", ToggleCommand.ticTacToeToggled);
			ticTacToe.displayString = "Tic Tac Toe Solver: " + Utils.getColouredBoolean(ToggleCommand.ticTacToeToggled);
		} else if (button == boulder) {
			ToggleCommand.boulderToggled = !ToggleCommand.boulderToggled;
			ConfigHandler.writeBooleanConfig("toggles", "BoulderPuzzle", ToggleCommand.boulderToggled);
			boulder.displayString = "Boulder Solver: " + Utils.getColouredBoolean(ToggleCommand.boulderToggled);
		} else if (button == silverfish) {
			ToggleCommand.silverfishToggled = !ToggleCommand.silverfishToggled;
			ConfigHandler.writeBooleanConfig("toggles", "SilverfishPuzzle", ToggleCommand.silverfishToggled);
			silverfish.displayString = "Silverfish Solver: " + Utils.getColouredBoolean(ToggleCommand.silverfishToggled);
		} else if (button == iceWalk) {
			ToggleCommand.iceWalkToggled = !ToggleCommand.iceWalkToggled;
			ConfigHandler.writeBooleanConfig("toggles", "IceWalkPuzzle", ToggleCommand.iceWalkToggled);
			iceWalk.displayString = "Ice Walk Solver: " + Utils.getColouredBoolean(ToggleCommand.iceWalkToggled);
		} else if (button == startsWith) {
			ToggleCommand.startsWithToggled = !ToggleCommand.startsWithToggled;
			ConfigHandler.writeBooleanConfig("toggles", "StartsWithTerminal", ToggleCommand.startsWithToggled);
			startsWith.displayString = "Starts With Letter Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.startsWithToggled);
		} else if (button == selectAll) {
			ToggleCommand.selectAllToggled = !ToggleCommand.selectAllToggled;
			ConfigHandler.writeBooleanConfig("toggles", "SelectAllTerminal", ToggleCommand.selectAllToggled);
			selectAll.displayString = "Select All Color Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.selectAllToggled);
		} else if (button == clickOrder) {
			ToggleCommand.clickInOrderToggled = !ToggleCommand.clickInOrderToggled;
			ConfigHandler.writeBooleanConfig("toggles", "ClickInOrderTerminal", ToggleCommand.clickInOrderToggled);
			clickOrder.displayString = "Click in Order Terminal Helper: " + Utils.getColouredBoolean(ToggleCommand.clickInOrderToggled);
		} else if (button == blockClicks) {
			ToggleCommand.blockWrongTerminalClicksToggled = !ToggleCommand.blockWrongTerminalClicksToggled;
			ConfigHandler.writeBooleanConfig("toggles", "BlockWrongTerminalClicks", ToggleCommand.blockWrongTerminalClicksToggled);
			blockClicks.displayString = "Block Wrong Clicks on Terminals: " + Utils.getColouredBoolean(ToggleCommand.blockWrongTerminalClicksToggled);
		} else if (button == itemFrameOnSeaLanterns) {
			ToggleCommand.itemFrameOnSeaLanternsToggled = !ToggleCommand.itemFrameOnSeaLanternsToggled;
			ConfigHandler.writeBooleanConfig("toggles", "IgnoreItemFrameOnSeaLanterns", ToggleCommand.itemFrameOnSeaLanternsToggled);
			itemFrameOnSeaLanterns.displayString = "Ignore Arrows On Sea Lanterns: " + Utils.getColouredBoolean(ToggleCommand.itemFrameOnSeaLanternsToggled);
		} else if (button == sameColour) {
			ToggleCommand.sameColourToggled = !ToggleCommand.sameColourToggled;
			ConfigHandler.writeBooleanConfig("toggles", "SameColourTerminal", ToggleCommand.sameColourToggled);
			sameColour.displayString = "Same Colour Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.sameColourToggled);
		}
	}
	
}
