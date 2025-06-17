1.
/*
Задача про здачу
Умова: Магазин видає здачу номіналами {50, 20, 10, 5, 1}.
Треба видати здачу сумою S з найменшою кількістю купюр.
 */
public class ChangeReturn {
    public static void main(String[] args) {
        int[] bills = {50, 20, 10, 5, 1};
        int S = 73;
        int count = 0;

        for (int i = 0; i < bills.length; i++) {
            while (S >= bills[i]) {
                S -= bills[i];
                count++;
            }
        }

        System.out.println("Купюр видано: " + count);
    }
}
2.
/*
Максимальний прибуток зі змагань
Умова:
Дано n змагань. Кожне змагання має:
час початку start[i],
час закінчення end[i],
прибуток profit[i].
Потрібно вибрати набір неперетинаючихся змагань так, щоб максимізувати загальний прибуток.
 */
        import java.util.Arrays;
import java.util.Comparator;

class Contest {
    int start;
    int end;
    int profit;

    public Contest(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class ContestProfit {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int[] profit = {50, 20, 100, 200, 150, 80};
        int n = start.length;

        Contest[] contests = new Contest[n];
        for (int i = 0; i < n; i++) {
            contests[i] = new Contest(start[i], end[i], profit[i]);
        }

        Arrays.sort(contests, Comparator.comparingInt(c -> c.end));

        int[] dp = new int[n];

        dp[0] = contests[0].profit;

        for (int i = 1; i < n; i++) {
            int profitWithoutCurrent = dp[i - 1];

            int profitWithCurrent = contests[i].profit;
            int lastCompatibleContestIndex = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (contests[j].end <= contests[i].start) {
                    lastCompatibleContestIndex = j;
                    break;
                }
            }

            if (lastCompatibleContestIndex != -1) {
                profitWithCurrent += dp[lastCompatibleContestIndex];
            }

            dp[i] = Math.max(profitWithoutCurrent, profitWithCurrent);
        }

        System.out.println("Максимальний прибуток: " + dp[n - 1]);
    }
}
3.
/*
Задача про графік уроків
Умова: Вибрати максимальну кількість неперетинаючихся уроків.
 */
public class LessonSchedule {
    public static void main(String[] args) {
        int[] start = {1, 2, 4, 6};
        int[] end = {3, 5, 6, 8};
        int n = start.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (end[i] > end[j]) {
                    swap(end, i, j);
                    swap(start, i, j);
                }
            }
        }

        int count = 1;
        int lastEnd = end[0];

        for (int i = 1; i < n; i++) {
            if (start[i] >= lastEnd) {
                count++;
                lastEnd = end[i];
            }
        }

        System.out.println("Максимум уроків: " + count);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
4.
/*
Задача про сонячні панелі
Умова: Встановити якнайбільше панелей, які вміщуються на даху довжиною L.
 */
        import java.util.Arrays;

public class SolarPanels {
    public static void main(String[] args) {
        int[] panels = {3, 2, 5, 1};
        int L = 7;

        for (int i = 0; i < panels.length - 1; i++) {
            for (int j = i + 1; j < panels.length; j++) {
                if (panels[i] > panels[j]) {
                    int temp = panels[i];
                    panels[i] = panels[j];
                    panels[j] = temp;
                }
            }
        }

        int total = 0;
        int count = 0;
        for (int i = 0; i < panels.length; i++) {
            if (total + panels[i] <= L) {
                total += panels[i];
                count++;
            }
        }

        System.out.println("Установлено панелей: " + count);
    }
}
5.
/*
Умова:
Є гирі {1, 3, 3, 5, 9}.
Потрібно набрати масу W, використовуючи найменшу кількість гир.
 */
public class WeightBalance {
    public static void main(String[] args) {
        int[] weights = {9, 5, 3, 3, 1};
        int W = 11;
        int count = 0;

        for (int i = 0; i < weights.length; i++) {
            while (W >= weights[i]) {
                W -= weights[i];
                count++;
            }
        }

        System.out.println("Гир використано: " + count);
    }
}