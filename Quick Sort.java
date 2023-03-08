

import java.util.Arrays;


public class Main
{
	public static void main(String[] args) {
		int arr[] = {6,3,9,5,2,8,7};
        int n = arr.length;

        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, n-1);

        System.out.println("sorted array");
        System.out.println(Arrays.toString(arr));
	}
}


class QuickSort
{
    void quickSort(int arr[], int beginIndex, int endIndex){
        //rekürsif fonksiyonlarda çıkış kısmı mutlaka düşünülmeli
        if(beginIndex >= endIndex){ 
            return;
        }

        int pivot = arr[endIndex];  //pivot dizinin sonundaki eleman seçilir
        int j = beginIndex-1;  // dizinin başlangıcı -1. elemanı gösterir yani dizinin dışı

        //bu aşamadan sonra verilen diziyi ya da verilen alt diziyi pivot ile kıyaslıyoruz
        //başlangıçtan başlar son index dahil olmadan devam eder, son index pivot elemandır
        for(int i=beginIndex; i<endIndex; i++){
            if(arr[i] < pivot){  //eğer bu eleman pivottan küçükse
                j++;    //hayali çizgi bir birim sağa ötelenir
                swap(arr, i, j); //hayali çizginin hemen sağındaki rakam, pivottan büyük olabilir
                                // sıradaki eleman ile hayali çizginin sağındaki eleman yer değiştirir
            }
        }

        j++; // döngü bittikten sonra pivot ile hayali çizginin sağında yer alan sayı yer değiştirir
        swap(arr, endIndex, j); // pivot bu aşamada olması gereken yere yerleşti
                               // sağda ve solda 2 ayrı dizi oluştu bu dizilerinde kendi arasında sıralanması gerekir
                                           // örn : 6 3 5 2 7 | 8 9 
        quickSort(arr, beginIndex, j-1);  //dizinin solunda kalan kısım için yeniden quicksort çağrılır
                                          //yeni gönderilen dizi beginIndex'ten j'ye kadar olacağı için j-1'e kadar gelmeli
        quickSort(arr, j+1, endIndex);    //dizinin  sağında kalan kısım için yeniden quicksort çağrılır j+1'den endIndex'e kadar getirilir
    }
    
    
     void swap(int arr[], int i, int j) {   //iki elemanın yer değiştirmesine dayalı swap kodu
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}





