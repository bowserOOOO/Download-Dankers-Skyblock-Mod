package me.Danker.commands;

import me.Danker.DankersSkyblockMod;
import me.Danker.features.loot.LootDisplay;
import me.Danker.handlers.ConfigHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class DisplayCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "display";
	}

	@Override
	public String getCommandUsage(ICommandSender arg0) {
		return "/" + getCommandName() + " <zombie/spider/wolf/enderman/blaze/fishing/catacombs/mythological/ghost/auto/off> [winter/festival/spooky/ch/lava/trophy/session/f(1-7)/mm]";
	}

	public static String usage(ICommandSender arg0) {
		return new DisplayCommand().getCommandUsage(arg0);
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		if (args.length == 1) {
			return getListOfStringsMatchingLastWord(args, "wolf", "spider", "zombie", "enderman", "blaze", "fishing", "catacombs", "mythological", "ghost", "auto", "off");
		} else if (args.length == 2 && args[0].equalsIgnoreCase("fishing")) {
			return getListOfStringsMatchingLastWord(args, "winter", "festival", "spooky", "ch", "lava", "trophy", "session");
		} else if (args.length == 2 && args[0].equalsIgnoreCase("catacombs")) {
			return getListOfStringsMatchingLastWord(args, "f1", "floor1", "f2", "floor2", "f3", "floor3", "f4", "floor4", "f5", "floor5", "f6", "floor6", "f7", "floor7", "mm", "master");
		} else if (args.length > 1) {
			return getListOfStringsMatchingLastWord(args, "session");
		}
		return null;
	}
	
	@Override
	public void processCommand(ICommandSender arg0, String[] arg1) throws CommandException {
		final EntityPlayer player = (EntityPlayer) arg0;
		
		if (arg1.length == 0) {
			player.addChatMessage(new ChatComponentText(DankersSkyblockMod.ERROR_COLOUR + "Usage: " + getCommandUsage(arg0)));
			return;
		}
		
		boolean showSession = arg1[arg1.length - 1].equalsIgnoreCase("session");

		switch (arg1[0].toLowerCase()) {
		case "wolf":
			if (showSession) {
				LootDisplay.display = "wolf_session";
			} else {
				LootDisplay.display = "wolf";
			}
			break;
		case "spider":
			if (showSession) {
				LootDisplay.display = "spider_session";
			} else {
				LootDisplay.display = "spider";
			}
			break;
		case "zombie":
			if (showSession) {
				LootDisplay.display = "zombie_session";
			} else {
				LootDisplay.display = "zombie";
			}
			break;
		case "enderman":
			if (showSession) {
				LootDisplay.display = "enderman_session";
			} else {
				LootDisplay.display = "enderman";
			}
			break;
		case "blaze":
			if (showSession) {
				LootDisplay.display = "blaze_session";
			} else {
				LootDisplay.display = "blaze";
			}
			break;
		case "fishing":
			if (arg1.length > 1) {
				switch (arg1[1].toLowerCase()) {
					case "winter":
						if (showSession) {
							LootDisplay.display = "fishing_winter_session";
						} else {
							LootDisplay.display = "fishing_winter";
						}
						break;
					case "festival":
						if (showSession) {
							LootDisplay.display = "fishing_festival_session";
						} else {
							LootDisplay.display = "fishing_festival";
						}
						break;
					case "spooky":
						if (showSession) {
							LootDisplay.display = "fishing_spooky_session";
						} else {
							LootDisplay.display = "fishing_spooky";
						}
						break;
					case "ch":
						if (showSession) {
							LootDisplay.display = "fishing_ch_session";
						} else {
							LootDisplay.display = "fishing_ch";
						}
						break;
					case "lava":
						if (showSession) {
							LootDisplay.display = "fishing_lava_session";
						} else {
							LootDisplay.display = "fishing_lava";
						}
						break;
					case "trophy":
						if (showSession) {
							LootDisplay.display = "fishing_trophy_session";
						} else {
							LootDisplay.display = "fishing_trophy";
						}
						break;
					default:
						if (showSession) {
							LootDisplay.display = "fishing_session";
						} else {
							LootDisplay.display = "fishing";
						}
				}
			} else {
				if (showSession) {
					LootDisplay.display = "fishing_session";
				} else {
					LootDisplay.display = "fishing";
				}
			}
			break;
		case "mythological":
			if (showSession) {
				LootDisplay.display = "mythological_session";
			} else {
				LootDisplay.display = "mythological";
			}
			break;
		case "catacombs":
			if (arg1.length == 1) {
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.ERROR_COLOUR + "Usage: /display catacombs <f1/f2/f3/f4f5/f6/f7>"));
				return;
			}
			
			switch (arg1[1].toLowerCase()) {
				case "f1":
				case "floor1":
					if (showSession) {
						LootDisplay.display = "catacombs_floor_one_session";
					} else {
						LootDisplay.display = "catacombs_floor_one";
					}
					break;
				case "f2":
				case "floor2":
					if (showSession) {
						LootDisplay.display = "catacombs_floor_two_session";
					} else {
						LootDisplay.display = "catacombs_floor_two";
					}
					break;
				case "f3":
				case "floor3":
					if (showSession) {
						LootDisplay.display = "catacombs_floor_three_session";
					} else {
						LootDisplay.display = "catacombs_floor_three";
					}
					break;
				case "f4":
				case "floor4":
					if (showSession) {
						LootDisplay.display = "catacombs_floor_four_session";
					} else {
						LootDisplay.display = "catacombs_floor_four";
					}
					break;
				case "f5":
				case "floor5":
					if (showSession) {
						LootDisplay.display = "catacombs_floor_five_session";
					} else {
						LootDisplay.display = "catacombs_floor_five";
					}
					break;
				case "f6":
				case "floor6":
					if (showSession) {
						LootDisplay.display = "catacombs_floor_six_session";
					} else {
						LootDisplay.display = "catacombs_floor_six";
					}
					break;
				case "f7":
				case "floor7":
					if (showSession) {
						LootDisplay.display = "catacombs_floor_seven_session";
					} else {
						LootDisplay.display = "catacombs_floor_seven";
					}
					break;
				case "mm":
				case "master":
					if (showSession) {
						LootDisplay.display = "catacombs_master_session";
					} else {
						LootDisplay.display = "catacombs_master";
					}
				default:
					player.addChatMessage(new ChatComponentText(DankersSkyblockMod.ERROR_COLOUR + "Usage: /display catacombs <f1/f2/f3/f4/f5/f6/f7/mm>"));
					return;
			}
			break;
		case "ghost":
			if (showSession) {
				LootDisplay.display = "ghost_session";
			} else {
				LootDisplay.display = "ghost";
			}
			break;
		case "auto":
			LootDisplay.auto = true;
			player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Display set to " + DankersSkyblockMod.SECONDARY_COLOUR + "auto" + DankersSkyblockMod.MAIN_COLOUR + "."));
			ConfigHandler.writeBooleanConfig("misc", "autoDisplay", true);
			return;
		case "off":
			LootDisplay.display = "off";
			break;
		default:
			player.addChatMessage(new ChatComponentText(DankersSkyblockMod.ERROR_COLOUR + "Usage: " + getCommandUsage(arg0)));
			return;
		}

		LootDisplay.auto = false;
		player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Display set to " + DankersSkyblockMod.SECONDARY_COLOUR + LootDisplay.display + DankersSkyblockMod.MAIN_COLOUR + "."));
		ConfigHandler.writeBooleanConfig("misc", "autoDisplay", false);
		ConfigHandler.writeStringConfig("misc", "display", LootDisplay.display);
	}

}
