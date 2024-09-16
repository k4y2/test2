package Ex5;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import spark.Spark;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class Main {
    static LoadingCache<Integer, String> primeCache = CacheBuilder.newBuilder()
            .build(new CacheLoader<Integer, String>() {
                @Override
                public String load(Integer n) throws Exception {
                    String listPrime = getPrime(n);
                    return listPrime;
                }
            });

    public static String getPrime(int n) {
        List<Integer> listPrime = new ArrayList<>();
        boolean isPrime = true;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) listPrime.add(i);
            isPrime = true;
        }

        return listPrime.toString();
    }


    public static void main(String[] args) {
        get("/prime", (req, resp) -> {
            int value = Integer.parseInt(req.queryParams("n"));
            return primeCache.get(value);
        });
    }
}
