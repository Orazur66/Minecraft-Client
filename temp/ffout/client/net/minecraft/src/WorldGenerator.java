// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            World

public abstract class WorldGenerator
{

    private final boolean field_41061_a;

    public WorldGenerator()
    {
        field_41061_a = false;
    }

    public WorldGenerator(boolean flag)
    {
        field_41061_a = flag;
    }

    public abstract boolean func_516_a(World world, Random random, int i, int j, int k);

    public void func_517_a(double d, double d1, double d2)
    {
    }

    protected void func_41060_a(World world, int i, int j, int k, int l, int i1)
    {
        if(field_41061_a)
        {
            world.func_688_b(i, j, k, l, i1);
        } else
        {
            world.func_643_a(i, j, k, l, i1);
        }
    }
}
