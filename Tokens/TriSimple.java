package com.Tokens;

import java.util.Arrays;

public class TriSimple {
	
	private int [] ma_table;
	private int nbElement=0;
	private int taille_Max;
	private int increment;
	
	public TriSimple() {
		
		this.ma_table = new int[10];
		this.taille_Max = 10;
		this.increment = 20;
	}
	
	public TriSimple(int t_max, int increment) {
		super();
		this.taille_Max = t_max;
		this.ma_table = new int[t_max];
		this.increment = increment;
	}
	
	public void Inserer_Elem(int elem) {
		// si le tableau est vide : 
		if(this.nbElement == 0)
		{
			this.ma_table[nbElement++] = elem;
		}
		else { 
			if(this.nbElement < this.taille_Max)
			{
				// premier cas : 
				if(this.ma_table[this.nbElement-1] <= elem)
				{
					this.ma_table[this.nbElement++] =elem;
				}else {
					// deuxieme cas : 
					for(int ind =0;ind< this.nbElement;ind++)
					{
						if(this.ma_table[ind] >= elem)
						{
							for(int pos=this.nbElement; pos >= ind+1; pos-- )
							{
								this.ma_table[pos] = this.ma_table[pos-1];
							}
							this.ma_table[ind] =elem;
							this.nbElement++;
							break;
						}
					}
				}
			} else {
				// on declare un nouveau tableau du taille + increment : 
				int new_size = this.taille_Max + this.increment;
				int [] newTab = new int[new_size];
				this.taille_Max = new_size;
				int ind_new_tab =0 ;
				
				// premier cas : 
				if(this.ma_table[this.nbElement-1] <= elem)
				{
					for(int i=0;i<this.nbElement;i++)
					{
						newTab[i] = this.ma_table[i];
					}
					newTab[this.nbElement++] = elem;
				}
				else {
					// deuxieme cas : 
					for(int i=0;i<this.nbElement;i++)
					{
						if(this.ma_table[i] < elem)
						{
							newTab[ind_new_tab++] = this.ma_table[i];
						}
						else {
							newTab[ind_new_tab++] =elem ;
							// completer le nouveau tableau par le contenu qui reste dans l'ancien tableau : 
							for(int ind =i ;ind<this.nbElement;ind++)
							{
								newTab[ind_new_tab++] = this.ma_table[ind];
							}
							
						}
					}
					
				}
				
				// affecter le nouveau tableau a l ancien tableu :
				this.ma_table = newTab;
			}
			
		}// fin de si le tableau n'est pas vide ;
	}
	
	
	public void Supprimer_dic_elem(int x)
	{
		int result =this.binarySearch(this.ma_table,0,this.nbElement-1,x);
		if( result !=-1)
		{
			for(int ind = result;ind <this.nbElement;ind++)
			{
				this.ma_table[ind]= this.ma_table[ind+1];
				
			}
			this.nbElement--;
			// test : 
			if(this.ma_table.length-this.nbElement >= 2 *this.increment)
			{
				int newsize = this.ma_table.length-this.nbElement;
				int [] tab_reduit = new int[newsize];
				this.taille_Max = newsize;
				for(int i_r=0;i_r<this.nbElement;i_r++)
				{
					tab_reduit[i_r]=this.ma_table[i_r];	
				}
				this.ma_table = tab_reduit;
			}
		}
		else {
			System.out.print("Element [ " + x + " ] est  Introuvable !! \n");
		}
	}
	public int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            if (arr[mid] == x)
                return mid;
 
      
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
	
	
	public String toString() {
		return "TriSimple -> [ma_table=" + Arrays.toString(ma_table) + "]";
	}
	
}

