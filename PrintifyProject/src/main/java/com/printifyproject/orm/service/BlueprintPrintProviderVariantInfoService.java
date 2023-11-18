package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintPrintProviderVariantDao;
import com.printifyproject.orm.model.BlueprintPrintProviderVariantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
