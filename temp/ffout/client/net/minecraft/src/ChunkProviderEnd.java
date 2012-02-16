// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, NoiseGeneratorOctaves, World, Block, 
//            Chunk, WorldChunkManager, MathHelper, BlockSand, 
//            BiomeGenBase, ChunkCoordIntPair, IProgressUpdate, EnumCreatureType, 
//            ChunkPosition

public class ChunkProviderEnd
    implements IChunkProvider
{

    private Random field_40396_i;
    private NoiseGeneratorOctaves field_40393_j;
    private NoiseGeneratorOctaves field_40394_k;
    private NoiseGeneratorOctaves field_40391_l;
    public NoiseGeneratorOctaves field_40388_a;
    public NoiseGeneratorOctaves field_40386_b;
    private World field_40392_m;
    private double field_40389_n[];
    private BiomeGenBase field_40390_o[];
    double field_40387_c[];
    double field_40384_d[];
    double field_40385_e[];
    double field_40382_f[];
    double field_40383_g[];
    int field_40395_h[][];

    public ChunkProviderEnd(World world, long l)
    {
        field_40395_h = new int[32][32];
        field_40392_m = world;
        field_40396_i = new Random(l);
        field_40393_j = new NoiseGeneratorOctaves(field_40396_i, 16);
        field_40394_k = new NoiseGeneratorOctaves(field_40396_i, 16);
        field_40391_l = new NoiseGeneratorOctaves(field_40396_i, 8);
        field_40388_a = new NoiseGeneratorOctaves(field_40396_i, 10);
        field_40386_b = new NoiseGeneratorOctaves(field_40396_i, 16);
    }

    public void func_40380_a(int i, int j, byte abyte0[], BiomeGenBase abiomegenbase[])
    {
        byte byte0 = 2;
        int k = byte0 + 1;
        int l = field_40392_m.field_35472_c / 4 + 1;
        int i1 = byte0 + 1;
        field_40389_n = func_40379_a(field_40389_n, i * byte0, 0, j * byte0, k, l, i1);
        for(int j1 = 0; j1 < byte0; j1++)
        {
            for(int k1 = 0; k1 < byte0; k1++)
            {
                for(int l1 = 0; l1 < field_40392_m.field_35472_c / 4; l1++)
                {
                    double d = 0.25D;
                    double d1 = field_40389_n[((j1 + 0) * i1 + (k1 + 0)) * l + (l1 + 0)];
                    double d2 = field_40389_n[((j1 + 0) * i1 + (k1 + 1)) * l + (l1 + 0)];
                    double d3 = field_40389_n[((j1 + 1) * i1 + (k1 + 0)) * l + (l1 + 0)];
                    double d4 = field_40389_n[((j1 + 1) * i1 + (k1 + 1)) * l + (l1 + 0)];
                    double d5 = (field_40389_n[((j1 + 0) * i1 + (k1 + 0)) * l + (l1 + 1)] - d1) * d;
                    double d6 = (field_40389_n[((j1 + 0) * i1 + (k1 + 1)) * l + (l1 + 1)] - d2) * d;
                    double d7 = (field_40389_n[((j1 + 1) * i1 + (k1 + 0)) * l + (l1 + 1)] - d3) * d;
                    double d8 = (field_40389_n[((j1 + 1) * i1 + (k1 + 1)) * l + (l1 + 1)] - d4) * d;
                    for(int i2 = 0; i2 < 4; i2++)
                    {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for(int j2 = 0; j2 < 8; j2++)
                        {
                            int k2 = j2 + j1 * 8 << field_40392_m.field_35471_b | 0 + k1 * 8 << field_40392_m.field_35473_a | l1 * 4 + i2;
                            int l2 = 1 << field_40392_m.field_35473_a;
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            for(int i3 = 0; i3 < 8; i3++)
                            {
                                int j3 = 0;
                                if(d15 > 0.0D)
                                {
                                    j3 = Block.field_40203_bK.field_376_bc;
                                }
                                abyte0[k2] = (byte)j3;
                                k2 += l2;
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }

                }

            }

        }

    }

    public void func_40381_b(int i, int j, byte abyte0[], BiomeGenBase abiomegenbase[])
    {
        for(int k = 0; k < 16; k++)
        {
            for(int l = 0; l < 16; l++)
            {
                int i1 = 1;
                int j1 = -1;
                byte byte0 = (byte)Block.field_40203_bK.field_376_bc;
                byte byte1 = (byte)Block.field_40203_bK.field_376_bc;
                for(int k1 = field_40392_m.field_35469_d; k1 >= 0; k1--)
                {
                    int l1 = (l * 16 + k) * field_40392_m.field_35472_c + k1;
                    byte byte2 = abyte0[l1];
                    if(byte2 == 0)
                    {
                        j1 = -1;
                        continue;
                    }
                    if(byte2 != Block.field_338_u.field_376_bc)
                    {
                        continue;
                    }
                    if(j1 == -1)
                    {
                        if(i1 <= 0)
                        {
                            byte0 = 0;
                            byte1 = (byte)Block.field_40203_bK.field_376_bc;
                        }
                        j1 = i1;
                        if(k1 >= 0)
                        {
                            abyte0[l1] = byte0;
                        } else
                        {
                            abyte0[l1] = byte1;
                        }
                        continue;
                    }
                    if(j1 > 0)
                    {
                        j1--;
                        abyte0[l1] = byte1;
                    }
                }

            }

        }

    }

    public Chunk func_538_d(int i, int j)
    {
        return func_533_b(i, j);
    }

    public Chunk func_533_b(int i, int j)
    {
        field_40396_i.setSeed((long)i * 0x4f9939f508L + (long)j * 0x1ef1565bd5L);
        byte abyte0[] = new byte[16 * field_40392_m.field_35472_c * 16];
        Chunk chunk = new Chunk(field_40392_m, abyte0, i, j);
        field_40390_o = field_40392_m.func_4075_a().func_4070_a(field_40390_o, i * 16, j * 16, 16, 16);
        func_40380_a(i, j, abyte0, field_40390_o);
        func_40381_b(i, j, abyte0, field_40390_o);
        chunk.func_1024_c();
        return chunk;
    }

    private double[] func_40379_a(double ad[], int i, int j, int k, int l, int i1, int j1)
    {
        if(ad == null)
        {
            ad = new double[l * i1 * j1];
        }
        double d = 684.41200000000003D;
        double d1 = 684.41200000000003D;
        field_40382_f = field_40388_a.func_4109_a(field_40382_f, i, k, l, j1, 1.121D, 1.121D, 0.5D);
        field_40383_g = field_40386_b.func_4109_a(field_40383_g, i, k, l, j1, 200D, 200D, 0.5D);
        d *= 2D;
        field_40387_c = field_40391_l.func_807_a(field_40387_c, i, j, k, l, i1, j1, d / 80D, d1 / 160D, d / 80D);
        field_40384_d = field_40393_j.func_807_a(field_40384_d, i, j, k, l, i1, j1, d, d1, d);
        field_40385_e = field_40394_k.func_807_a(field_40385_e, i, j, k, l, i1, j1, d, d1, d);
        int k1 = 0;
        int l1 = 0;
        for(int i2 = 0; i2 < l; i2++)
        {
            for(int j2 = 0; j2 < j1; j2++)
            {
                double d2 = (field_40382_f[l1] + 256D) / 512D;
                if(d2 > 1.0D)
                {
                    d2 = 1.0D;
                }
                double d3 = field_40383_g[l1] / 8000D;
                if(d3 < 0.0D)
                {
                    d3 = -d3 * 0.29999999999999999D;
                }
                d3 = d3 * 3D - 2D;
                float f = (float)((i2 + i) - 0) / 1.0F;
                float f1 = (float)((j2 + k) - 0) / 1.0F;
                float f2 = 100F - MathHelper.func_1113_c(f * f + f1 * f1) * 8F;
                if(f2 > 80F)
                {
                    f2 = 80F;
                }
                if(f2 < -100F)
                {
                    f2 = -100F;
                }
                if(d3 > 1.0D)
                {
                    d3 = 1.0D;
                }
                d3 /= 8D;
                d3 = 0.0D;
                if(d2 < 0.0D)
                {
                    d2 = 0.0D;
                }
                d2 += 0.5D;
                d3 = (d3 * (double)i1) / 16D;
                l1++;
                double d4 = (double)i1 / 2D;
                for(int k2 = 0; k2 < i1; k2++)
                {
                    double d5 = 0.0D;
                    double d6 = (((double)k2 - d4) * 8D) / d2;
                    if(d6 < 0.0D)
                    {
                        d6 *= -1D;
                    }
                    double d7 = field_40384_d[k1] / 512D;
                    double d8 = field_40385_e[k1] / 512D;
                    double d9 = (field_40387_c[k1] / 10D + 1.0D) / 2D;
                    if(d9 < 0.0D)
                    {
                        d5 = d7;
                    } else
                    if(d9 > 1.0D)
                    {
                        d5 = d8;
                    } else
                    {
                        d5 = d7 + (d8 - d7) * d9;
                    }
                    d5 -= 8D;
                    d5 += f2;
                    int l2 = 2;
                    if(k2 > i1 / 2 - l2)
                    {
                        double d10 = (float)(k2 - (i1 / 2 - l2)) / 64F;
                        if(d10 < 0.0D)
                        {
                            d10 = 0.0D;
                        }
                        if(d10 > 1.0D)
                        {
                            d10 = 1.0D;
                        }
                        d5 = d5 * (1.0D - d10) + -3000D * d10;
                    }
                    l2 = 8;
                    if(k2 < l2)
                    {
                        double d11 = (float)(l2 - k2) / ((float)l2 - 1.0F);
                        d5 = d5 * (1.0D - d11) + -30D * d11;
                    }
                    ad[k1] = d5;
                    k1++;
                }

            }

        }

        return ad;
    }

    public boolean func_537_a(int i, int j)
    {
        return true;
    }

    public void func_534_a(IChunkProvider ichunkprovider, int i, int j)
    {
        BlockSand.field_466_a = true;
        int k = i * 16;
        int l = j * 16;
        BiomeGenBase biomegenbase = field_40392_m.func_4075_a().func_4073_a(k + 16, l + 16);
        biomegenbase.func_35477_a(field_40392_m, field_40392_m.field_1037_n, k, l);
        BlockSand.field_466_a = false;
    }

    public boolean func_535_a(boolean flag, IProgressUpdate iprogressupdate)
    {
        return true;
    }

    public boolean func_532_a()
    {
        return false;
    }

    public boolean func_536_b()
    {
        return true;
    }

    public String func_21109_c()
    {
        return "RandomLevelSource";
    }

    public List func_40377_a(EnumCreatureType enumcreaturetype, int i, int j, int k)
    {
        WorldChunkManager worldchunkmanager = field_40392_m.func_4075_a();
        if(worldchunkmanager == null)
        {
            return null;
        }
        BiomeGenBase biomegenbase = worldchunkmanager.func_4074_a(new ChunkCoordIntPair(i >> 4, k >> 4));
        if(biomegenbase == null)
        {
            return null;
        } else
        {
            return biomegenbase.func_25063_a(enumcreaturetype);
        }
    }

    public ChunkPosition func_40376_a(World world, String s, int i, int j, int k)
    {
        return null;
    }
}
