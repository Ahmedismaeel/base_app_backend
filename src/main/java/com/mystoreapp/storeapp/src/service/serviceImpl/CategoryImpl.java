package com.mystoreapp.storeapp.src.service.serviceImpl;

import com.mystoreapp.storeapp.src.dao.CategoryDao;
import com.mystoreapp.storeapp.src.dto.CategoryDto;
import com.mystoreapp.storeapp.src.helper.FileNameHelper;
import com.mystoreapp.storeapp.src.helper.FileSystemStorage;
import com.mystoreapp.storeapp.src.model.Category;
import com.mystoreapp.storeapp.src.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final FileSystemStorage fileSystemStorage;
    @Override
    @Transactional
    public void save(String title , MultipartFile file) {

        fileSystemStorage.store(file, FileNameHelper.getFileName(file));

        categoryDao.saveCategory(Category.builder().title(title).image(FileNameHelper.getFileName(file)).build());
        return;
    }



    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Override
    public Category getCategoryById(long id) {
      var category =  categoryDao.getCategoryById(id);
      if(category == null){
          throw new RuntimeException("");
      }
      return categoryDao.getCategoryById(id);
    }
}
