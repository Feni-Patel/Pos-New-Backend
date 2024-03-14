package org.pgs.postp.service;

import org.pgs.postp.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getAllInventories();

    InventoryDTO getInventoryById(Long id);

    InventoryDTO createInventory(InventoryDTO inventoryDTO);

    InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO);

    void deleteInventory(Long id);
}
