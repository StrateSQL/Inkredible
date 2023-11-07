package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintPrintProviderVariantDao;
import com.printifyproject.orm.dto.BlueprintPrintProviderVariantInfoDto;
import com.printifyproject.orm.model.BlueprintPrintProviderVariantEntity;
import com.printifyproject.orm.model.ColorEntity;
import com.printifyproject.orm.model.SizeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlueprintPrintProviderVariantInfoService {

    @Autowired
    private BlueprintPrintProviderVariantDao dao;

    @Autowired
    private ColorService colorService;

    @Autowired
    private SizeService sizeService;

    private List<BlueprintPrintProviderVariantEntity> blueprintPrintProviderVariants;

    public BlueprintPrintProviderVariantInfoService() {}

    public BlueprintPrintProviderVariantInfoService(Integer blueprintPrintProviderId) {
        this.blueprintPrintProviderVariants = dao.findByBlueprintPrintProvider(blueprintPrintProviderId);
    }

    public List<BlueprintPrintProviderVariantInfoDto> getBlueprintPrintProviderVariantInfo() {
        List<BlueprintPrintProviderVariantInfoDto> results = new ArrayList<>();

        for (var blueprintPrintProviderVariant : blueprintPrintProviderVariants) {
            var item = new BlueprintPrintProviderVariantInfoDto();
            item.setBlueprintPrintProviderVariantId(blueprintPrintProviderVariant.getId());
            item.setVariantKey(blueprintPrintProviderVariant.getVariantKey());

            // Fetch ColorEntity using ColorService
            Optional<ColorEntity> colorEntity = colorService.findById(blueprintPrintProviderVariant.getColor().getId());
            colorEntity.ifPresent(color -> item.setColor(color.getColor()));

            // Fetch SizeEntity using SizeService
            Optional<SizeEntity> sizeEntity = sizeService.findById(blueprintPrintProviderVariant.getSize().getId());
            sizeEntity.ifPresent(size -> item.setSize(size.getSize()));

            results.add(item);
        }
        return results;
    }
}
