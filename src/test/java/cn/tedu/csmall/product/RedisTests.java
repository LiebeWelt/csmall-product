package cn.tedu.csmall.product;

import cn.tedu.csmall.product.pojo.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@SpringBootTest
public class RedisTests {

    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    @Test
    void setValue(){
        String key = "name";
        String value = "fanchuanqi";

        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        ops.set(key, value);
        log.debug("已经向Redis中写入Key为【{}】的数据：{}", key, value);
    }

    @Test
    void getValue() {
        String key = "name";

        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("已经从Redis中取出Key为【{}】的数据：{}", key, value);
    }

    @Test
    void setObjectValue() {
        String key = "brand1";
        Brand brand = new Brand();
        brand.setId(1L);
        brand.setName("测试品牌");

        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        ops.set(key, brand);
        log.debug("已经向Redis中写入Key为【{}】的数据：{}", key, brand);
    }

    @Test
    void getObjectValue() {
        String key = "brand1";

        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("已经从Redis中取出Key为【{}】的数据：{}", key, value);
        log.debug("取出的数据的类型是：{}", value.getClass().getName());
    }

    @Test
    void getNull() {
        String key = "hahahaha";

        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("已经从Redis中取出Key为【{}】的数据：{}", key, value);
    }

    @Test
    void keys() {
        String keyPattern = "*";
        Set<String> keys = redisTemplate.keys(keyPattern);
        log.debug("查询当前Redis中所有的Key，Key的数量：{}", keys.size());
        for (String key : keys) {
            log.debug("key = {}", key);
        }
    }

    @Test
    void delete() {
        String key = "name";
        Boolean result = redisTemplate.delete(key);
        log.debug("删除Key为【{}】的数据，结果：{}", key, result);
    }

    @Test
    void deleteX() {
        String keyPattern = "*";
        Set<String> keys = redisTemplate.keys(keyPattern);
        Long count = redisTemplate.delete(keys);
        log.debug("删除多条数据【Keys={}】完成，删除的数据的数量：{}", keys, count);
    }

    @Test
    void setList() {
        List<Brand> brands = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            Brand brand = new Brand();
            brand.setId(i + 0L);
            brand.setName("测试品牌" + i);
            brands.add(brand);
        }

        String key = "brands";
        ListOperations<String, Serializable> ops = redisTemplate.opsForList(); // 得到List集合的操作器
        for (Brand brand : brands) {
            ops.rightPush(key, brand);
        }
        log.debug("向Redis中写入列表数据完成，Key为【{}】，写入的列表为：{}", key, brands);
    }

    @Test
    void listSize() {
        String key = "brands";
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        Long size = ops.size(key);
        log.debug("在Redis中Key为【{}】的列表的长度为：{}", key, size);
    }

    @Test
    void listRange() {
        String key = "brands";
        long start = 0;
        long end = -1;
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        List<Serializable> list = ops.range(key, start, end);
        log.debug("从Redis中读取Key为【{}】的列表，start={}，end={}，获取到的列表长度为：{}",
                key, start, end, list.size());
        for (Serializable item : list) {
            log.debug("{}", item);
        }
    }
}
