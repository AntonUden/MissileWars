/*******************************************************************************
 * Copyright (C) 2020 Linux4
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package de.linux4.missilewars.v112.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;

import de.linux4.missilewars.listener.ItemPickupListener;

public class ItemPickupListener112 extends ItemPickupListener {

	@EventHandler
	public void onItemPickup(EntityPickupItemEvent event) {
		if (event.getEntity() instanceof Player && this.callback != null) {
			this.callback.eventCalled(event, (Player) event.getEntity(), event.getItem());
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onArrowPickup(PlayerPickupArrowEvent event) { // on < 1.12 this is handled by item pickup event
		if (this.callback != null) {
			this.callback.eventCalled(event, event.getPlayer(), event.getItem());
		}
	}

}
